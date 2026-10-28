package classes;

import interfaces.IWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReportWriter implements IWriter {

    @Override
    public void writeReport(String filename, String content) {
        try (FileWriter filewriter = new FileWriter(filename);
             PrintWriter writer = new PrintWriter(filewriter)) {

            writer.print(content);
            System.out.println("Report successfully saved: " + filename);

        } catch (IOException e) {
            System.out.println("[Error] Report can not be saved: " + e.getMessage());
        }
    }
}

