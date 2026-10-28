import classes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MyForm {
    private JPanel panel;
    private JButton sync;
    private JButton report;
    private JButton calories;
    private JButton exit;
    private JLabel option;

    private SmartWatch watch;
    private DataReader reader;

    public static void main(String[] args) {
        JFrame frame = new JFrame("SmartWatch");
        MyForm myform = new MyForm();

        frame.setContentPane(myform.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public MyForm() {

        try {
            sync.setIcon(new ImageIcon(getClass().getResource("/icons/sync.png")));
            report.setIcon(new ImageIcon(getClass().getResource("/icons/doc.png")));
            calories.setIcon(new ImageIcon(getClass().getResource("/icons/calories.png")));
            exit.setIcon(new ImageIcon(getClass().getResource("/icons/exit.png")));
            sync.setIconTextGap(10);
            report.setIconTextGap(10);
            calories.setIconTextGap(10);
            exit.setIconTextGap(10);}
        catch (Exception e) {
            System.out.println("Missing icon: " + e.getMessage());
        }

        watch = new SmartWatch();
        reader = new DataReader();

        sync.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<HealthData> loadedList = reader.readData();
                if (loadedList != null && !loadedList.isEmpty()) {
                    watch.getdata().clear();
                    for (HealthData hd : loadedList) {
                        watch.getdata().add(hd);
                    }
                    JOptionPane.showMessageDialog(null, "Sync successful! " + loadedList.size() + " days loaded.");
                } else {
                    JOptionPane.showMessageDialog(null, "File not found or empty at 'src/data.txt'!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (watch.getdata().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No data available! Sync first.");
                    return;
                }
                DailyReport dailyReport = new DailyReport();
                String summary = dailyReport.generateSummary(watch.getdata());
                JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(summary, 15, 45)), "Report", JOptionPane.PLAIN_MESSAGE);
            }
        });
        calories.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (watch.getdata().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No data available! Sync first.");
                    return;
                }
                String[] sports = {"1. Running", "2. Cycling", "3. Hiking"};
                String selected = (String) JOptionPane.showInputDialog(null, "Select sport:", "Workout", JOptionPane.QUESTION_MESSAGE, null, sports, sports[0]);

                if (selected != null) {
                    int type;
                    if (selected.startsWith("1")) {
                        type = 1;
                    } else if (selected.startsWith("2")) {
                        type = 2;
                    } else {
                        type = 3;
                    }
                    watch.startWorkoutMode(type);
                    WorkoutReport workoutReport = new WorkoutReport(type);
                    String summary = workoutReport.generateSummary(watch.getdata());
                    JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(summary, 12, 45)), "Workout Summary", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }



}
