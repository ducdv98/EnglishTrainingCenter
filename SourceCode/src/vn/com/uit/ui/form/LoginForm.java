package vn.com.uit.ui.form;

import dtos.StaffDto;
import vn.uit.com.business.service.LoginService;
import vn.uit.com.contracts.service.ILoginService;
import vn.uit.com.contracts.ui.ILoginForm;

/**
 *
 * @author Duc DV
 */
public class LoginForm extends javax.swing.JFrame implements ILoginForm {

    /*
    * Local variable
     */
    private ILoginService _loginService;

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        inits();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblErrorMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setLocationByPlatform(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(32, 33, 35));

        jLabel1.setForeground(new java.awt.Color(57, 113, 77));
        jLabel1.setLabelFor(txtUsername);
        jLabel1.setText("Username");

        txtUsername.setBackground(new java.awt.Color(32, 33, 35));
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setBorder(null);
        txtUsername.setCaretColor(new java.awt.Color(255, 255, 255));
        txtUsername.setNextFocusableComponent(txtPassword);
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(57, 113, 77));
        jLabel3.setLabelFor(txtPassword);
        jLabel3.setText("Password");

        txtPassword.setBackground(new java.awt.Color(32, 33, 35));
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setBorder(null);
        txtPassword.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPassword.setNextFocusableComponent(btnLogin);
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(128, 87, 194));
        btnLogin.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(128, 87, 194));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(51, 52, 54));
        jLabel4.setText("©Copyright 2018 - UIT");

        lblErrorMsg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblErrorMsg.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorMsg.setFocusable(false);
        lblErrorMsg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(133, 133, 133))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblErrorMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1)
                    .addComponent(txtUsername)
                    .addComponent(jSeparator3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblErrorMsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inits() {
        _loginService = new LoginService(this);
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (txtUsername.getText().equals("") || txtPassword.getText().equals("")) {
            lblErrorMsg.setText("Chưa nhập tên tài khoản hoặc mật khẩu!");
            lblErrorMsg.setVisible(true);
            return;
        }
        _loginService.login(txtUsername.getText(), txtPassword.getText());
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        if (lblErrorMsg.isVisible()) {
            lblErrorMsg.setVisible(false);
        }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        if (lblErrorMsg.isVisible()) {
            lblErrorMsg.setVisible(false);
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblErrorMsg;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onLoginSuccessful(StaffDto employee) {
        dispose();
        MainForm main = new MainForm(employee);
        main.setVisible(true);
    }

    @Override
    public void onLoginFailure(String errorMsg) {
        lblErrorMsg.setText("Tên tài khoản hoặc mật khẩu không đúng!");
        lblErrorMsg.setVisible(true);
        txtPassword.setText("");
        txtUsername.setText("");
    }
}
