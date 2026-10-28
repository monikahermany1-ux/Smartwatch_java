package classes;

import java.util.List;

public abstract class ReportGenerator {
    protected String reportTitle;

    public ReportGenerator(String reportTitle) {

        this.reportTitle = reportTitle;
    }

    public abstract String generateSummary(List<HealthData> dataList);
}
