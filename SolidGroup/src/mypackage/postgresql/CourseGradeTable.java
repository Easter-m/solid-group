package mypackage.postgresql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import static jdk.internal.org.jline.utils.InfoCmp.Capability.columns;


public class CourseGradeTable extends JFrame {

    public CourseGradeTable() {
        setTitle("Average grade per course");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    String[] columnnames = {"Course Name", "Average Grade"};

    DefaultTableModel model = new DefaultTableModel(columnnames, 0 );
    JTable table = new JTable(model);

    public void myMethod() {
        try{
            JDBCPostgresql connector = new JDBCPostgresql();
            Connection connection = connector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(
                    "SELECT c.coursename, average(e.grade) as averagegrade"+
                            "FROM Courses c"+
                            "Join Enrollment e ON c.courseid = s.studentid"+
                            "GROUP BY c.courseid");

            while (resultset.next()){
                model.addRow(new Object[]{
                        resultset.getString("coursename"),
                        resultset.getDouble("averagegrade")
                });

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        add(new JScrollPane(table));
    }
}
