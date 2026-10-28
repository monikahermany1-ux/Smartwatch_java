package classes;

import java.util.List;

public class WorkoutReport extends ReportGenerator{
    private int sportType;

    public WorkoutReport(int sportType) {
        super("WORKOUT REPORT");
        this.sportType = sportType;
    }

    @Override
    public String generateSummary(List<HealthData> dataList) {
        HealthAnalyzer analyzer = new HealthAnalyzer();
        String sportName;
        if (sportType == 1) {
            sportName = "Running";
        } else if (sportType == 2) {
            sportName = "Cycling";
        } else {
            sportName = "Hiking";
        }
        String summary = "==================================================\n";
        summary += "          " + super.reportTitle + "           \n";
        summary += "==================================================\n";
        summary += "  Activity Profile:  " + sportName + "\n";
        summary += "  Tracking Duration: " + dataList.size() + " days\n";

        int totalCalories = 0;
        String dailyActivity = "";

        for (int i = 0; i < dataList.size(); i++) {
            HealthData hd = dataList.get(i);
            int calories = analyzer.calculateCalories(hd, sportType);
            totalCalories += calories;
            dailyActivity += (i + 1) + ". day: In " + hd.getActivityMinutes()
                    + " active minutes " + calories + " kcal was burned\n";
        }

        summary += "  Total Energy Burn: " + totalCalories + " kcal\n";
        if (!dataList.isEmpty()) {
            summary += "  Average per Day:   " + (totalCalories / dataList.size()) + " kcal/day\n";
        }
        summary += "--------------------------------------------------\n";
        summary += dailyActivity;
        summary += "--------------------------------------------------\n";

        if (totalCalories > 1500) {
            summary += "  Status: EXCELLENT! High energy output. Keep it up!\n";
        } else {
            summary += "  Status: ACTIVE. Consistency is key to reaching your goals.\n";
        }

        return summary;
    }
}

