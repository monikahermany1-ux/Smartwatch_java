package classes;

import java.util.List;

public class DailyReport extends ReportGenerator{
    public DailyReport() {
        super("DAILY HEALTH & ACTIVITY OVERVIEW");
    }

    @Override
    public String generateSummary(List<HealthData> dataList) {
        HealthAnalyzer analyzer = new HealthAnalyzer();
        String summary = "==================================================\n";
        summary += "       " + super.reportTitle + "           \n";
        summary += "==================================================\n";

        for (int i = 0; i < dataList.size(); i++) {
            HealthData hd = dataList.get(i);
            summary += "\n DAY " + (i + 1) + ".\n";
            summary += "Heart rate: " + hd.getHeartRate()
                    + " bpm | Steps: " + hd.getSteps()
                    + " | Sleep: " + hd.getSleepHours()
                    + " hour | Activity minutes: " + hd.getActivityMinutes() + "\n";

            int stress = analyzer.stressLevel(hd);
            summary += "Stress index: " + analyzer.Feedback(stress) + "\n";
            summary += "Activity level: " + analyzer.movementFeedback(analyzer.movement(hd)) + "\n";

            int score = analyzer.calculateHealthScore(hd);
            summary += "Vital score: " + score + "/100 [" + analyzer.ScoreRate(score) + "]\n";
        }

        return summary;
    }
}
