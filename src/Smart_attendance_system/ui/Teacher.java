/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smart_attendance_system.ui;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author pc
 */
public class Teacher extends javax.swing.JPanel {
   private String teacherName;
    private Login parent;

    public Teacher(Login parent, String teacherName) {
        this.parent = parent;
        this.teacherName = teacherName;
        initComponents();
        initCustomLayout();
    }

    private void initCustomLayout() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(800, 550));

        // Sidebar
        JPanel sidebar = new JPanel(null);
        sidebar.setBounds(0, 0, 200, 550);
        sidebar.setBackground(new Color(0, 153, 255));
        add(sidebar);

        JLabel lblTitle = new JLabel("Teacher Portal");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setBounds(20, 30, 160, 30);
        sidebar.add(lblTitle);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(20, 480, 160, 30);
        btnLogout.addActionListener(e -> parent.switchPage("LOGIN"));
        sidebar.add(btnLogout);

        // Main Content Area
        JLabel lblWelcome = new JLabel("Welcome, Prof. " + teacherName);
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblWelcome.setBounds(230, 30, 500, 40);
        add(lblWelcome);

        // Action Card
        JPanel cardMark = new JPanel(null);
        cardMark.setBounds(230, 100, 250, 150);
        cardMark.setBackground(new Color(243, 245, 255));
        cardMark.setBorder(BorderFactory.createLineBorder(new Color(0, 153, 255), 1));
        add(cardMark);

        JLabel lblMark = new JLabel("Mark Attendance");
        lblMark.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblMark.setBounds(20, 20, 200, 25);
        cardMark.add(lblMark);

        JButton btnGo = new JButton("Open Sheet");
        btnGo.setBounds(20, 90, 210, 35);
        btnGo.setBackground(new Color(0, 153, 255));
        btnGo.setForeground(Color.WHITE);
        cardMark.add(btnGo);
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
