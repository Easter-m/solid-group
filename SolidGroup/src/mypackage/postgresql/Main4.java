package mypackage.postgresql;

import javax.swing.*;

public class Main4 {
    public static void main(String[] args) {


        SwingUtilities.invokeLater(() -> {
            StudentGrade frame = new StudentGrade();
            frame.setVisible(true);
        });
    }
}
