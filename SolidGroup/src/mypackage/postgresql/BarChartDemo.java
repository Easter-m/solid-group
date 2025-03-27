package mypackage.postgresql;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartDemo extends JFrame{

    public BarChartDemo() {
        setTitle("Students enrolled in each Course");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    public void myMethod() {
       try{
           JDBCPostgresql connector = new JDBCPostgresql();
           Connection connection = connector.getConnection();
           Statement statement = connection.createStatement();
           ResultSet resultset = statement.executeQuery("SELECT c.coursename, COUNT(e.studentid) as studentcount"+
                   "FROM Courses c LEFT JOIN enrollment e ON c.courseid = s.studentid"+"GROUP BY c.courseid");

               while (resultset.next()){
                   dataset.addValue(
                           resultset.getInt("studentcount"),
                                   "Students",
                           resultset.getString("coursename")
                   );
               }
           }catch (SQLException e){
               e.printStackTrace();
           }
       JFreeChart chart = ChartFactory.createBarChart(
              "Number of students enrolled in each course",
              "Course",
              "Number of students",
              dataset);

       ChartPanel chartPanel = new ChartPanel(chart);
       setContentPane(chartPanel);


       }
    }









