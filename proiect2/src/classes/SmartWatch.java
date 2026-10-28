package classes;

import interfaces.IWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//Simulează funcționarea unui ceas inteligent, gestionând o listă de date de sănătate și utilizând classes.HealthAnalyzer pentru a procesa și afișa rapoartele
public class SmartWatch {
    private List<HealthData> data = new ArrayList<>();

    public void addHealthData(int heartRate, int steps, double sleepHours, int activityMinutes) {
        HealthData i = new HealthData(heartRate, steps, sleepHours, activityMinutes);
        this.data.add(i);
    }

    public List<HealthData> getdata() {

        return data;
    }

    public void startWorkoutMode(int sportType) {
        if (data.isEmpty()) {
            return;
        }

        WorkoutReport workoutReport = new WorkoutReport(sportType);
        String reportContent = workoutReport.generateSummary(this.data);

        ReportWriter reportWriter = new ReportWriter();
        reportWriter.writeReport("src/workout_report.txt", reportContent);
    }
}

