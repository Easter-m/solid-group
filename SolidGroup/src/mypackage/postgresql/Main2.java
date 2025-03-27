package mypackage.postgresql;

import javax.swing.*;

public class Main2 {
    public static void main(String[] args){
        PieChartDemo chart2 = new PieChartDemo();
        chart2.setTitle("Grade Distribution Pie Chart");
        chart2.setSize(800, 600);
        chart2.setLocationRelativeTo(null);
        chart2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chart2.setVisible(true);
        chart2.myMethod();
    }
}
