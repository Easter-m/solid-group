package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginPage extends JFrame implements ActionListener {
    private Container container;
    private JLabel userLabel, passwordLabel, titleLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton, resetButton;
    private JCheckBox showPassword;
    private Image backgroundImage;

    public LoginPage() {
        setTitle("Login Page");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        backgroundImage = new ImageIcon("C:\\Users\\Rue\\Downloads\\uni.jpeg").getImage();


        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout());
        container = getContentPane();
        container.add(backgroundPanel);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        titleLabel = new JLabel("University management system🔒");
        titleLabel.setFont(new Font("Blackadder ITC", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        backgroundPanel.add(titleLabel, gbc);

        userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Fairwater Script Light", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        backgroundPanel.add(userLabel, gbc);

        userTextField = new JTextField();
        userTextField.setFont(new Font("Fairwater Script Light", Font.PLAIN, 15));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(10, 10, 10, 10);
        backgroundPanel.add(userTextField, gbc);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        backgroundPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Fairwater Script Light", Font.PLAIN, 15));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(10, 10, 10, 10);
        backgroundPanel.add(passwordField, gbc);

        showPassword = new JCheckBox("Show Password");
        showPassword.setFont(new Font("Fairwater Script Light", Font.PLAIN, 15));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(10, 10, 10, 10);
        backgroundPanel.add(showPassword, gbc);
        showPassword.addActionListener(this);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        backgroundPanel.add(loginButton, gbc);
        loginButton.addActionListener(this);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        backgroundPanel.add(resetButton, gbc);
        resetButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText = userTextField.getText();
            String pwdText = new String(passwordField.getPassword());
            if (userText.equalsIgnoreCase("admin") && pwdText.equals("admin1234")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }

        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}

