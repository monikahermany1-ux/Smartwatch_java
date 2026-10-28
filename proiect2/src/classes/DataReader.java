package classes;

import interfaces.IReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Se ocupă cu citirea datelor de sănătate dintr-un fișier text extern și transformarea acestora în obiecte de tip classes.HealthData.
public class DataReader implements IReader {

//    Citește datele din fișierul specificat și returnează o listă de obiecte classes.HealthData
    public List<HealthData> readData() {

        File myFile = new File("src/data.txt");
        Scanner sc = null;

        try {
            sc = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }

        List<HealthData> dataList = new ArrayList<>();
        while (sc.hasNextLine()) {

            int heartRate = sc.nextInt();
            int steps = sc.nextInt();
            double sleepHours = sc.nextDouble();
            int activityMinutes = sc.nextInt();

            //Instanțiez un nou obiect 'classes.HealthData' prin constructorul cu argumente și îl adaug în lista dinamică 'dataList'.
            HealthData healthData= new HealthData(heartRate, steps, sleepHours, activityMinutes);
            dataList.add(healthData);
            System.out.println(healthData);

        }
        sc.close();
        return dataList;
    }

}


