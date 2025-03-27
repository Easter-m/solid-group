package mypackage.postgresql;

import javax.swing.*;
import java.awt.*;

class UniversityCourseManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(UniversityDashboard::new);
    }
}

class UniversityDashboard extends JFrame {
    public UniversityDashboard() {
        setTitle("University Course Management System");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnViewCourses = new JButton("View Courses");
        JButton btnEnrollStudents = new JButton("Enroll Students");
        JButton btnViewAnalytics = new JButton("View Analytics");
        JButton btnExit = new JButton("Exit");

        panel.add(btnViewCourses);
        panel.add(btnEnrollStudents);
        panel.add(btnViewAnalytics);
        panel.add(btnExit);

        add(panel, BorderLayout.CENTER);

        btnViewCourses.addActionListener(_ -> new ViewCoursesWindow());
        btnEnrollStudents.addActionListener(_ -> new EnrollStudentsWindow());
        btnViewAnalytics.addActionListener(_ -> new ViewAnalyticsWindow());
        btnExit.addActionListener(_ -> System.exit(0));

        setVisible(true);
    }
}

class ViewCoursesWindow extends JFrame {
    public ViewCoursesWindow() {
        setTitle("Courses");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] columns = {"Course ID", "Course Name", "Credit", "Instructor"};
        JTable table = getJTable(columns);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private static JTable getJTable(String[] columns) {
        String[][] data = {
                {"1201", "Data Science", "21", "Justin Bieber"},
                {"1202", "Procurement", "21", "Kendrick Lamar"},
                {"1203", "Cisco Certified Network Associate", "20", "Deeya Rajgor"},
                {"1205", "Informatics and Computer Science", "20", "Vinesh Rajgor"},
                {"1204", "Cloud Computing", "17", "Christopher Chan"},
                {"1206", "Information Technology", "25", "Racheal Sommers"}
        };

        JTable table = new JTable(data, columns);
        return table;
    }
}

class EnrollStudentsWindow extends JFrame {
    public EnrollStudentsWindow() {
        setTitle("Enroll Students");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Student Name:"));
        JTextField txtStudentName = new JTextField();
        panel.add(txtStudentName);

        panel.add(new JLabel("Grades:"));
        JTextField txtGrades = new JTextField();
        panel.add(txtGrades);

        panel.add(new JLabel("Course:"));
        String[] courses = {"Data Science", "Procurement","Cisco Certified Network Associate","Informatics and Computer Science","Cloud Computing","Information Technology"};
        JComboBox<String> comboCourses = new JComboBox<>(courses);
        panel.add(comboCourses);

        JButton btnEnroll = new JButton("Enroll");
        panel.add(btnEnroll);

        btnEnroll.addActionListener(_ -> JOptionPane.showMessageDialog(this, "Student Enrolled Successfully"));

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}

class ViewAnalyticsWindow extends JFrame {
    public ViewAnalyticsWindow() {
        setTitle("Analytics");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextArea textArea = new JTextArea("Analytics will be displayed here.");
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        setVisible(true);

        
    }
}
