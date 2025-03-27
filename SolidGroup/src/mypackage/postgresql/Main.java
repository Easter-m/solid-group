package mypackage.postgresql;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        BarChartDemo chart = new BarChartDemo();
        chart.setTitle("Course Enrollment Bar Chart");
        chart.setSize(800, 600);
        chart.setLocationRelativeTo(null);
        chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chart.setVisible(true);
        chart.myMethod();

    }

}

