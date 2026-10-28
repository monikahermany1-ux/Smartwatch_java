package classes;

//Reprezintă entitatea de date de sănătate ale unui utilizator, stocând valorile colectate de ceasul inteligent pentru o singură zi
public class HealthData {

    // Proprietăți / Membrii clasei
    private int heartRate;
    private int steps;
    private double sleepHours;
    private int activityMinutes;

//    Constructor cu argumente pentru inițializarea datelor de sănătate
    public HealthData(int heartRate, int steps, double sleepHours, int activityMinutes) {
        this.heartRate = heartRate;
        this.steps = steps;
        this.sleepHours = sleepHours;
        this.activityMinutes = activityMinutes;
    }

    public int getHeartRate() {

        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public double getSleepHours() {
        return sleepHours;
    }

    public void setSleepHours(double sleepHours) {
        this.sleepHours = sleepHours;
    }

    public int getActivityMinutes() {
        return activityMinutes;
    }

    public void setActivityMinutes(int activityMinutes) {
        this.activityMinutes = activityMinutes;
    }

//    Metoda toString() pentru reprezentarea textuala a obiectului.
    public String toString(){
        return "Heart rate: " + heartRate+
                " Steps: " + steps+
                " Sleep: " + sleepHours+
                " Activity: " + activityMinutes;
    }


}

