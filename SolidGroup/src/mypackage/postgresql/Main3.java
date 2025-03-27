package mypackage.postgresql;

import javax.swing.*;

public class Main3 {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            CourseGradeTable frame = new CourseGradeTable();
            frame.setVisible(true);
        });
    }
}
