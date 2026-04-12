/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smart_attendance_system.ui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class Signup_UI extends javax.swing.JPanel {

private Login parent; // Link to the Main Login class
    
    // UI Components
    private JTextField txtName, txtID;
    private JPasswordField txtPass, txtConfirmPass;
    private JComboBox<String> cbRole, cbDept, cbSemester, cbSection;
    private JLabel lblID, lblPass, lblConfirm;
    private JButton btnSignUp;
    private JPanel dynamicPanel;
    private ArrayList<JCheckBox> subjectBoxes = new ArrayList<>();

    public Signup_UI(Login parent) {
        this.parent = parent;
        initComponents();     // Auto-generated code at the bottom
        initCustomLayout();   // Your custom professional design
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
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int panelW = getWidth(), panelH = getHeight();
                int imgW = img.getWidth(null), imgH = img.getHeight(null);
                int newH = (imgH * panelW) / imgW;
                g2d.drawImage(img, 0, (panelH - newH) / 2, panelW, newH, null);
            }
        }
    }

    private void initCustomLayout() {
        Color purpleTint = new Color(243, 245, 255);
        Color actionBlue = new Color(0, 153, 255);

        this.setLayout(null);
        this.setPreferredSize(new Dimension(800, 550));
        this.setBackground(Color.WHITE);

        // ---------- LEFT PANEL (Illustration) ----------
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

        int startY = 20;

        JLabel lblRolePrompt = new JLabel("Role");
        lblRolePrompt.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblRolePrompt.setBounds(50, startY, 300, 20);
        right.add(lblRolePrompt);

        cbRole = new JComboBox<>(new String[]{"Student", "Teacher"});
        cbRole.setBounds(50, startY + 20, 300, 30);
        cbRole.setBackground(Color.WHITE);
        right.add(cbRole);

        JLabel lblName = new JLabel("Full Name");
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblName.setBounds(50, startY + 60, 300, 20);
        right.add(lblName);
        
        txtName = new JTextField();
        txtName.setBounds(50, startY + 80, 300, 30);
        right.add(txtName);

        lblID = new JLabel("Enrollment Number");
        lblID.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblID.setBounds(50, startY + 120, 300, 20);
        right.add(lblID);
        
        txtID = new JTextField();
        txtID.setBounds(50, startY + 140, 300, 30);
        right.add(txtID);

        JLabel lblDeptLabel = new JLabel("Department");
        lblDeptLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblDeptLabel.setBounds(50, startY + 180, 300, 20);
        right.add(lblDeptLabel);
        
        cbDept = new JComboBox<>(new String[]{
            "Computer Science", "Software Engineering", "Information Tech.", "Artificial Intelligence"
        });
        cbDept.setBounds(50, startY + 200, 300, 30);
        cbDept.setBackground(Color.WHITE);
        right.add(cbDept);

        // DYNAMIC AREA
        dynamicPanel = new JPanel(null);
        dynamicPanel.setBounds(50, startY + 240, 300, 100);
        dynamicPanel.setBackground(Color.WHITE);
        right.add(dynamicPanel);

        // BOTTOM ELEMENTS
        lblPass = new JLabel("Password");
        lblPass.setFont(new Font("Segoe UI", Font.BOLD, 12));
        right.add(lblPass);

        txtPass = new JPasswordField();
        right.add(txtPass);

        lblConfirm = new JLabel("Confirm Password");
        lblConfirm.setFont(new Font("Segoe UI", Font.BOLD, 12));
        right.add(lblConfirm);

        txtConfirmPass = new JPasswordField();
        right.add(txtConfirmPass);

        btnSignUp = new JButton("Create Account");
        btnSignUp.setBackground(actionBlue);
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // --- ACTION: Go back to Login after "signing up" ---

        // --- ACTION: Validate and Sign Up ---
        btnSignUp.addActionListener(e -> {
            String name = txtName.getText().trim();
            String id = txtID.getText().trim();
            String role = cbRole.getSelectedItem().toString();
            String pass = new String(txtPass.getPassword());
            String confirmPass = new String(txtConfirmPass.getPassword());

            // 1. Check for empty fields
            if (name.isEmpty() || id.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 2. Password Match Check
            if (!pass.equals(confirmPass)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 3. Teacher-specific validation (at least one subject check)
            if (role.equals("Teacher")) {
                boolean subjectSelected = false;
                for (JCheckBox cb : subjectBoxes) {
                    if (cb.isSelected()) {
                        subjectSelected = true;
                        break;
                    }
                }
                if (!subjectSelected) {
                    JOptionPane.showMessageDialog(this, "Please select at least one subject.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            // 4. If validation passes
            JOptionPane.showMessageDialog(this, "Account Created Successfully!");
            parent.switchPage("LOGIN");
        });
        right.add(btnSignUp);

        cbRole.addActionListener(e -> updateDynamicFields(cbRole.getSelectedItem().toString()));
        updateDynamicFields("Student"); // Initial call

        this.add(right);
    }

    private void updateDynamicFields(String role) {
        dynamicPanel.removeAll();
        subjectBoxes.clear();
        int currentY = 0;

        if (role.equals("Student")) {
            lblID.setText("Enrollment Number");
            JLabel semLabel = new JLabel("Semester");
            semLabel.setBounds(0, currentY, 145, 20);
            dynamicPanel.add(semLabel);
            cbSemester = new JComboBox<>(new String[]{"1","2","3","4","5","6","7","8"});
            cbSemester.setBounds(0, currentY + 20, 145, 30);
            dynamicPanel.add(cbSemester);

            JLabel secLabel = new JLabel("Section");
            secLabel.setBounds(155, currentY, 145, 20);
            dynamicPanel.add(secLabel);
            cbSection = new JComboBox<>(new String[]{"A","B","C","D"});
            cbSection.setBounds(155, currentY + 20, 145, 30);
            dynamicPanel.add(cbSection);
            currentY += 60;
        } else {
            lblID.setText("Employee ID");
            JLabel subLabel = new JLabel("Assigned Subjects");
            subLabel.setBounds(0, currentY, 300, 20);
            dynamicPanel.add(subLabel);
            JPanel subGrid = new JPanel(new GridLayout(2, 2, 5, 5));
            subGrid.setBounds(0, currentY + 20, 300, 60);
            subGrid.setBackground(Color.WHITE);
            String[] subjects = {"Mathematics", "Communication", "Programming", "Digital Logic"};
            for (String sub : subjects) {
                JCheckBox chk = new JCheckBox(sub);
                chk.setBackground(Color.WHITE);
                subjectBoxes.add(chk);
                subGrid.add(chk);
            }
            dynamicPanel.add(subGrid);
            currentY += 85;
        }

        dynamicPanel.setSize(300, currentY);
        int baseY = dynamicPanel.getY() + dynamicPanel.getHeight() + 10;
        lblPass.setBounds(50, baseY, 300, 20);
        txtPass.setBounds(50, baseY + 20, 300, 30);
        lblConfirm.setBounds(50, baseY + 60, 300, 20);
        txtConfirmPass.setBounds(50, baseY + 80, 300, 30);
        btnSignUp.setBounds(50, baseY + 125, 300, 40);

        dynamicPanel.revalidate();
        dynamicPanel.repaint();
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