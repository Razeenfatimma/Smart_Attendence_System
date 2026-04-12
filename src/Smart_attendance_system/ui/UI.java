/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smart_attendance_system.ui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;


/**
 *
 * @author pc
 */
public class UI extends javax.swing.JPanel {
private Login parent; 

    public UI(Login parent) {
        this.parent = parent;
        initComponents(); // This calls the Auto-generated code at the bottom
        customInit();     // This calls your custom design
    }

    // --- INNER CLASS FOR SHARP IMAGE RENDERING ---
    class ImagePanel extends JPanel {
        private Image img;
        public ImagePanel(Image img) { this.img = img; setOpaque(true); }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int panelW = getWidth();
                int panelH = getHeight();
                int imgW = img.getWidth(null);
                int imgH = img.getHeight(null);

                int newW = panelW;
                int newH = (imgH * newW) / imgW;
                int yPos = (panelH - newH) / 2;
                g2d.drawImage(img, 0, yPos, newW, newH, null);
            }
        }
    }

    private void customInit() {
        Color purpleTint = new Color(243, 245, 255); 
        Color actionBlue = new Color(0, 153, 255);
        
        this.setLayout(null);
        this.setPreferredSize(new Dimension(800, 550));
        this.setBackground(Color.WHITE);

        // ---------- LEFT PANEL ----------
        URL sideUrl = getClass().getResource("/Smart_attendance_system/ui/img/side.png");
        if (sideUrl != null) {
            ImagePanel left = new ImagePanel(new ImageIcon(sideUrl).getImage());
            left.setBounds(0, 0, 400, 550);
            left.setBackground(purpleTint);
            this.add(left);
        }

        // ---------- RIGHT PANEL ----------
        JPanel right = new JPanel(null);
        right.setBounds(400, 0, 400, 550);
        right.setBackground(Color.WHITE);

        // LOGO
        JLabel logo = new JLabel();
        URL logoUrl = getClass().getResource("/Smart_attendance_system/ui/img/logo.png");
        if (logoUrl != null) {
            Image img = new ImageIcon(logoUrl).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            logo.setIcon(new ImageIcon(img));
        }
        logo.setBounds(140, 20, 120, 120);
        right.add(logo);

        // ENROLLMENT
        JLabel lblEnroll = new JLabel("Enrollment");
        lblEnroll.setBounds(80, 150, 240, 20);
        lblEnroll.setFont(new Font("Segoe UI", Font.BOLD, 13));
        right.add(lblEnroll);

        JTextField txtUser = new JTextField();
        txtUser.setBounds(80, 175, 240, 30);
        right.add(txtUser);

        // PASSWORD
        JLabel lblPass = new JLabel("Password");
        lblPass.setBounds(80, 215, 240, 20);
        lblPass.setFont(new Font("Segoe UI", Font.BOLD, 13));
        right.add(lblPass);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(80, 240, 240, 30);
        right.add(txtPass);

        // LOGIN AS
        JLabel lblRole = new JLabel("Login As");
        lblRole.setBounds(80, 285, 240, 20);
        lblRole.setFont(new Font("Segoe UI", Font.BOLD, 13));
        right.add(lblRole);

        String[] roles = {"Student", "Teacher"};
        JComboBox<String> roleBox = new JComboBox<>(roles);
        roleBox.setBounds(80, 310, 240, 30);
        roleBox.setBackground(Color.WHITE);
        right.add(roleBox);

        // LOGIN BUTTON
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(80, 370, 240, 40);
        btnLogin.setBackground(actionBlue);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        right.add(btnLogin);

        // SIGN UP SECTION
        JLabel lblNoAcc = new JLabel("No account?");
        lblNoAcc.setBounds(110, 430, 80, 20);
        lblNoAcc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        right.add(lblNoAcc);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(185, 430, 80, 20);
        btnSignUp.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnSignUp.setForeground(actionBlue);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setContentAreaFilled(false);
        btnSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // --- ACTION: Switch to Signup Page ---
        btnSignUp.addActionListener(e -> {
            parent.switchPage("SIGNUP");
        });
        
        right.add(btnSignUp);
        this.add(right);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
