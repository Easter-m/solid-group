package mypackage.postgresql;


import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


public class PieChartDemo extends JFrame {

    public PieChartDemo() {
        setTitle("Grade Distribution");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        DefaultPieDataset dataset = new DefaultPieDataset();

        public void myMethod(){

            try{
                JDBCPostgresql connector = new JDBCPostgresql();
                Connection connection = connector.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultset = statement.executeQuery(
                    "SELECT"+
                            "CASE"+
                            "WHEN grade >= 70 THEN 'A'"+
                            "WHEN grade >= 60 THEN 'B'"+
                            "WHEN grade >= 50 THEN 'C'"+
                            "WHEN grade >= 40 THEN 'D'"+
                            "ELSE 'F'"+
                            "END as gradelevel,"+
                            "COUNT(*) as count"+
                            "FROM Enrollments"+
                            "GROUP BY gradelevel");


                    while(resultset.next()){
                        dataset.setValue(resultset.getString("gradelevel"),
                                resultset.getInt("count")
                        );


                    }


        } catch (SQLException e) {
               e.printStackTrace();
            }

        JFreeChart chart = ChartFactory.createPieChart(
                "Grade Distribution",
                dataset,
                true,
                true,
                false
        );

            ChartPanel chartPanel = new ChartPanel(chart);
            setContentPane(chartPanel);


        }
}
