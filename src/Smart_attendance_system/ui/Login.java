
package Smart_attendance_system.ui;

import javax.swing.*;
import java.awt.event.*;
import Smart_attendance_system.model.*; 
import Smart_attendance_system.logic.File_Manager;
import java.awt.*;
  


public class Login extends JFrame{
private CardLayout cardLayout;
    private JPanel mainPanel;

    public Login() {
        setTitle("Smart Attendance System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 580); 
        setLocationRelativeTo(null);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Pass 'this' so the panels can call switchPage
        UI loginPage = new UI(this);
        Signup_UI signupPage = new Signup_UI(this);

        mainPanel.add(loginPage, "LOGIN");
        mainPanel.add(signupPage, "SIGNUP");

        add(mainPanel);
        cardLayout.show(mainPanel, "LOGIN");
    }

    public void switchPage(String pageName) {
        cardLayout.show(mainPanel, pageName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }}
