/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smart_attendance_system.ui;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author pc
 */
public class Student extends javax.swing.JPanel {
    private String studentName;
    private Login parent;

    public Student(Login parent, String studentName) {
        this.parent = parent;
        this.studentName = studentName;
        initComponents();
        initCustomLayout();
    }

    private void initCustomLayout() {
        this.setLayout(null);
        this.setBackground(new Color(243, 245, 255));
        this.setPreferredSize(new Dimension(800, 550));

        // Header Section
        JPanel header = new JPanel(null);
        header.setBounds(0, 0, 800, 100);
        header.setBackground(Color.WHITE);
        add(header);

        JLabel lblName = new JLabel("Student Dashboard: " + studentName);
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblName.setBounds(30, 35, 500, 30);
        header.add(lblName);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(680, 35, 80, 30);
        btnLogout.addActionListener(e -> parent.switchPage("LOGIN"));
        header.add(btnLogout);

        // Attendance Percentage Card
        JPanel statsPanel = new JPanel(null);
        statsPanel.setBounds(50, 130, 700, 200);
        statsPanel.setBackground(Color.WHITE);
        statsPanel.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        add(statsPanel);

        JLabel lblPerc = new JLabel("78%");
        lblPerc.setFont(new Font("Segoe UI", Font.BOLD, 64));
        lblPerc.setForeground(new Color(0, 153, 255));
        lblPerc.setBounds(40, 40, 150, 80);
        statsPanel.add(lblPerc);

        JLabel lblInfo = new JLabel("Current Attendance Status");
        lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblInfo.setBounds(40, 120, 300, 25);
        statsPanel.add(lblInfo);

        JLabel lblMsg = new JLabel("You are eligible for exams.");
        lblMsg.setForeground(new Color(0, 153, 76));
        lblMsg.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        lblMsg.setBounds(40, 150, 300, 25);
        statsPanel.add(lblMsg);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
