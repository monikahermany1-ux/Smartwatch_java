package classes;

//Conține logica de analiză a parametrilor de sănătate, calculând nivelul de stres, nivelul de activitate și scorul general de sănătate
public class HealthAnalyzer {

//    Calculează nivelul de stres pe o scară de la 1 la 3 în funcție de ritmul cardiac și somn
    public int stressLevel(HealthData data) {
        int heartRate = data.getHeartRate();
        double sleep = data.getSleepHours();


        if (heartRate > 85 && sleep < 7.0) {
            return 3;
        } else if (heartRate > 75 || sleep < 7.0) {
            return 2;
        } else {
            return 1;
        }
    }
//    Calculează nivelul de mișcare (activitate fizică) pe o scară de la 1 la 3 în funcție de pași și minute active
    public int movement(HealthData data) {
        int steps = data.getSteps();
        int activity = data.getActivityMinutes();
        if (steps > 8000 && activity > 45) {
            return 3;
        } else if (steps > 5000 || activity > 20) {
            return 2;
        } else {
            return 1;
        }
    }

//    Returnează un mesaj text corespunzător nivelului de stres
    public String Feedback(int stressLevel) {
        switch (stressLevel) {
            case 1:
                return "Optimal - Your body is well-rested and recovered.";
            case 2:
                return "Moderate - Elevated physical or emotional strain detected.";
            case 3:
                return "High Alert - Critical stress indicators! Please take a rest.";
            default:
                return "Unable to determine stress indicators.";
        }
    }

//    Returnează un mesaj text corespunzător nivelului de mișcare
    public String movementFeedback(int movement) {
        switch (movement) {
            case 1:
                return "Sedentary - Consider taking a short walk to reach your goals.";
            case 2:
                return "Active - You are maintaining a steady, healthy routine.";
            case 3:
                return "Excellent - Outstanding physical performance today!";
            default:
                return "Activity metrics unavailable.";
        }
    }

//    Calculează un scor general de sănătate între 0 și 100 bazat pe penalizări aplicate parametrilor slabi
    public int calculateHealthScore(HealthData data){
        int score=100;
        if(data.getHeartRate()>90) score-=20;
        else if (data.getHeartRate()>80) score-=10;

         if (data.getSleepHours()<6.0) score-=25;
         else if(data.getSleepHours()<7.0) score-=10;

         if(data.getSteps()<4000) score-=15;
         else if(data.getSteps()>8000) score-=5;

         if(score <0) {
         score=0;
         }
         return score;
    }

    public String ScoreRate(int score){
        if(score>=80) return "EXCELLENT";
        if(score>=50) return "BALANCED";
        return "NEEDS ATTENTION";
    }
//    Calculează caloriile arse în funcție de tipul de sport, minutele active și ritmul cardiac
    public int calculateCalories(HealthData data, int sportType) {
        double factor = 1.0;
        switch (sportType) {
            case 1:
                factor = 0.2;
                break;
            case 2:
                factor = 0.14;
                break;
            case 3:
                factor = 0.08;
                break;
        }
        double calories = data.getActivityMinutes() * data.getHeartRate() * factor;
        return (int) calories; //Type Casting (conversie explicită) de la double la int
    }
}
