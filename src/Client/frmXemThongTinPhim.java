/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Client;

import Entity.Phim;
import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class frmXemThongTinPhim extends javax.swing.JFrame {
    public Config config = new Config();
    private static String idKH;
    private static Phim phim;
    
    public frmXemThongTinPhim(String idkh, Phim p) {
        idKH = idkh;
        phim = p;
        initComponents();
        
        txtTenPhim.setText("Tên Phim: "+phim.getTenPhim());
        txtThoiLuong.setText("Thời Lượng: "+phim.getThoiLuong() + " phút");
        txtDaoDien.setText("Đạo Diễn: "+phim.getDaoDien());
        txtDienVien.setText("Diễn Viên: "+phim.getDienVien());
        txtDoiTuongXem.setText("Đối Tượng Xem: "+phim.getDoTuoi());
        txtKhoiChieu.setText("Khởi Chiếu: "+phim.getKhoiChieu());
        txtLoaiPhim.setText("Loại: "+phim.getLoai());
        txtMoTa.setText("<html>Mô tả: "+phim.getMoTa()+"</html>");
        
        try {
            ImageIcon imageIcon =  new ImageIcon(new URL(phim.getAnh()));
            btnImage.setIcon(imageIcon);

        } catch (MalformedURLException ex) {
            Logger.getLogger(frmXemThongTinPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTenPhim = new javax.swing.JLabel();
        txtThoiLuong = new javax.swing.JLabel();
        txtLoaiPhim = new javax.swing.JLabel();
        txtDaoDien = new javax.swing.JLabel();
        txtDienVien = new javax.swing.JLabel();
        txtKhoiChieu = new javax.swing.JLabel();
        txtDoiTuongXem = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JLabel();
        btnTroLai = new javax.swing.JButton();
        btnMuaVe = new javax.swing.JButton();
        btnImage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Đặt Vé Xem Phim");

        jPanel1.setBackground(new java.awt.Color(19, 15, 64));

        jPanel2.setBackground(new java.awt.Color(48, 51, 107));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Vé Xem Phim");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        txtTenPhim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTenPhim.setForeground(new java.awt.Color(255, 255, 255));
        txtTenPhim.setText("Tên Phim:");

        txtThoiLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtThoiLuong.setForeground(new java.awt.Color(255, 255, 255));
        txtThoiLuong.setText("Thời Lượng:");

        txtLoaiPhim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLoaiPhim.setForeground(new java.awt.Color(255, 255, 255));
        txtLoaiPhim.setText("Loại Phim:");

        txtDaoDien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDaoDien.setForeground(new java.awt.Color(255, 255, 255));
        txtDaoDien.setText("Đạo Diễn:");

        txtDienVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDienVien.setForeground(new java.awt.Color(255, 255, 255));
        txtDienVien.setText("Diễn Viên:");

        txtKhoiChieu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtKhoiChieu.setForeground(new java.awt.Color(255, 255, 255));
        txtKhoiChieu.setText("Khởi Chiếu:");

        txtDoiTuongXem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDoiTuongXem.setForeground(new java.awt.Color(255, 255, 255));
        txtDoiTuongXem.setText("Đối Tượng Xem:");

        txtMoTa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMoTa.setForeground(new java.awt.Color(255, 255, 255));
        txtMoTa.setText("Mô Tả:");

        btnTroLai.setBackground(new java.awt.Color(48, 51, 107));
        btnTroLai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTroLai.setForeground(new java.awt.Color(255, 255, 255));
        btnTroLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/left-arrow.png"))); // NOI18N
        btnTroLai.setText("Quay Lại");
        btnTroLai.setBorder(null);
        btnTroLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroLaiActionPerformed(evt);
            }
        });

        btnMuaVe.setBackground(new java.awt.Color(48, 51, 107));
        btnMuaVe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMuaVe.setForeground(new java.awt.Color(255, 255, 255));
        btnMuaVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/right-arrow.png"))); // NOI18N
        btnMuaVe.setText("Đặt Vé");
        btnMuaVe.setBorder(null);
        btnMuaVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuaVeActionPerformed(evt);
            }
        });

        btnImage.setBackground(new java.awt.Color(19, 15, 64));
        btnImage.setBorder(null);
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(btnTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(btnMuaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnImage, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDoiTuongXem)
                            .addComponent(txtKhoiChieu)
                            .addComponent(txtDienVien)
                            .addComponent(txtDaoDien)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtThoiLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTenPhim)
                                .addComponent(txtLoaiPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMoTa)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnImage, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMuaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txtTenPhim)
                        .addGap(18, 18, 18)
                        .addComponent(txtThoiLuong)
                        .addGap(22, 22, 22)
                        .addComponent(txtLoaiPhim)
                        .addGap(18, 18, 18)
                        .addComponent(txtDaoDien)
                        .addGap(18, 18, 18)
                        .addComponent(txtDienVien)
                        .addGap(18, 18, 18)
                        .addComponent(txtKhoiChieu)
                        .addGap(18, 18, 18)
                        .addComponent(txtDoiTuongXem)
                        .addGap(18, 18, 18)
                        .addComponent(txtMoTa)))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Mô tả");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTroLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroLaiActionPerformed
        frmChonPhim chonPhim = new frmChonPhim(idKH);
        this.setVisible(false);
    }//GEN-LAST:event_btnTroLaiActionPerformed

    private void btnMuaVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuaVeActionPerformed
        frmChonRap chonRap = new frmChonRap(idKH, phim.getIdPhim());
        this.setVisible(false);
    }//GEN-LAST:event_btnMuaVeActionPerformed

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        if (Desktop.isDesktopSupported()){
            try 
            {
                Desktop.getDesktop().browse(new URI(phim.getTrailer()));
            }
            catch (IOException | URISyntaxException ex) {
                Logger.getLogger(frmXemThongTinPhim.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnImageActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmXemThongTinPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {           
            new frmXemThongTinPhim(idKH, phim).setVisible(true);            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImage;
    private javax.swing.JButton btnMuaVe;
    private javax.swing.JButton btnTroLai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txtDaoDien;
    private javax.swing.JLabel txtDienVien;
    private javax.swing.JLabel txtDoiTuongXem;
    private javax.swing.JLabel txtKhoiChieu;
    private javax.swing.JLabel txtLoaiPhim;
    private javax.swing.JLabel txtMoTa;
    private javax.swing.JLabel txtTenPhim;
    private javax.swing.JLabel txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
