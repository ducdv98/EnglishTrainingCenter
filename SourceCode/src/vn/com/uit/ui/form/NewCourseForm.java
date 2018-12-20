package vn.com.uit.ui.form;

import dtos.CourseDto;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import vn.com.uit.common.Constants;
import vn.uit.com.business.service.CourseService;
import vn.uit.com.contracts.service.ICourseService;
import vn.uit.com.contracts.ui.IDialogForm;

/**
 *
 * @author Admin
 */
public class NewCourseForm extends javax.swing.JDialog implements IDialogForm {

    private ICourseService _service;

    /**
     * Creates new form CourseNewForm
     */
    public NewCourseForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initialization();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtFee = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txtDuration = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtBenchMark = new javax.swing.JTextField();
        bntCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tạo khoá học mới");
        setResizable(false);

        jLabel2.setForeground(new java.awt.Color(57, 113, 77));
        jLabel2.setText("Tên khoá học");

        txtName.setBackground(new java.awt.Color(204, 204, 204));
        txtName.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(51, 51, 51));
        txtName.setBorder(null);
        txtName.setCaretColor(new java.awt.Color(102, 102, 102));
        txtName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtName.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 313, Short.MAX_VALUE))
            .addComponent(txtName)
            .addComponent(jSeparator2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel3.setForeground(new java.awt.Color(57, 113, 77));
        jLabel3.setText("Học phí");

        txtFee.setBackground(new java.awt.Color(204, 204, 204));
        txtFee.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtFee.setForeground(new java.awt.Color(51, 51, 51));
        txtFee.setBorder(null);
        txtFee.setCaretColor(new java.awt.Color(102, 102, 102));
        txtFee.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFee.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(txtFee)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel5.setForeground(new java.awt.Color(57, 113, 77));
        jLabel5.setText("Thời gian kéo dài (tuần)");

        txtDuration.setBackground(new java.awt.Color(204, 204, 204));
        txtDuration.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtDuration.setForeground(new java.awt.Color(51, 51, 51));
        txtDuration.setBorder(null);
        txtDuration.setCaretColor(new java.awt.Color(102, 102, 102));
        txtDuration.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDuration.setOpaque(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(txtDuration)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel7.setForeground(new java.awt.Color(57, 113, 77));
        jLabel7.setText("Điểm đầu vào");

        txtBenchMark.setBackground(new java.awt.Color(204, 204, 204));
        txtBenchMark.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtBenchMark.setForeground(new java.awt.Color(51, 51, 51));
        txtBenchMark.setBorder(null);
        txtBenchMark.setCaretColor(new java.awt.Color(102, 102, 102));
        txtBenchMark.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtBenchMark.setOpaque(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(txtBenchMark)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBenchMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bntCreate.setText("Tạo");
        bntCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntCreate)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntCreate)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bntCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCreateActionPerformed
        if (!validateInput()) {
            return;
        }
        CourseDto course = new CourseDto();
        course.setName(txtName.getText());
        course.setDuration(Integer.parseInt(txtDuration.getText()));
        course.setBenchmark(Float.parseFloat(txtBenchMark.getText()));
        course.setFee(new BigDecimal(txtFee.getText()));

        _service.addCourse(course);
    }//GEN-LAST:event_bntCreateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCreate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField txtBenchMark;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtFee;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void displayMessage(int status, String msg) {
        if (status == Constants.STATUS_OK) {
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, msg, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public int showDialog() {
        setVisible(true);
        return Constants.STATUS_OK;
    }

    @Override
    public void initialization() {
        _service = new CourseService(this, Constants.MODE_NEW);
    }

    @Override
    public void onLoading() {

    }

    @Override
    public boolean validateInput() {
        if (txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tên không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            int duration = Integer.parseInt(txtDuration.getText());
            if (duration <= 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thời gian không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            if (new BigDecimal(txtFee.getText()).compareTo(BigDecimal.ZERO) <= 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Học phí không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            if (Float.parseFloat(txtBenchMark.getText()) < 0 || Float.parseFloat(txtBenchMark.getText()) > 10) {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Điểm đầu vào không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}