package mypackage.postgresql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import static jdk.internal.org.jline.utils.InfoCmp.Capability.columns;

public class StudentGrade extends JFrame {

    public StudentGrade() {
        setTitle("Student and marks per course");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    String[] columnnames = {"Student Name", "Grade", "Course Name"};

    DefaultTableModel model = new DefaultTableModel(columnnames, 0 );
    JTable table = new JTable(model);

    public void myMethod() {
        try{
            JDBCPostgresql connector = new JDBCPostgresql();
            Connection connection = connector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(
                    "SELECT s.studentname, c.coursename, e.grade"+
                            "FROM student s"+
                            "JOIN enrollment e ON s.studentid = e.studentid"+
                            "JOIN course c ON c.courseid = s.studentid");

            while(resultset.next()){
                model.addRow(new Object[]{
                resultset.getString("studentname"),
                resultset.getString("coursename"),
                resultset.getDouble("grade")
            });
            }

            }catch(SQLException e){
        e.printStackTrace();
        }
        add(new JScrollPane(table));
        setVisible(true);

    }

}
