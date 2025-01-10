/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TA;
import TA.DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class UbahPassworddanUsername extends javax.swing.JFrame {
    Connection koneksi;
    int userID;


    public UbahPassworddanUsername() {
        initComponents();
        try {
            // Memanggil koneksi hanya sekali ketika objek Utama dibuat
            this.koneksi = DatabaseConnection.getConnection();
            System.out.println("Koneksi berhasil!");
        } catch (SQLException e) {
            System.err.println("Gagal terhubung ke database: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAtas = new javax.swing.JPanel();
        LabPanelAtas = new javax.swing.JLabel();
        LabUsername = new javax.swing.JLabel();
        LabNamaUser = new javax.swing.JLabel();
        TFUsername = new javax.swing.JTextField();
        TFNamaUser = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        KonfPassword = new javax.swing.JPasswordField();
        WORD = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        ButPanel = new javax.swing.JPanel();
        btnbatal = new javax.swing.JButton();
        Btnubah = new javax.swing.JButton();
        Btnsimpan = new javax.swing.JButton();
        LabPassSaIni = new javax.swing.JLabel();
        LabKonfPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informasi Pengguna");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelAtas.setBackground(new java.awt.Color(0, 0, 0));

        LabPanelAtas.setForeground(new java.awt.Color(255, 255, 255));
        LabPanelAtas.setText("PENGELOLA USER");

        javax.swing.GroupLayout panelAtasLayout = new javax.swing.GroupLayout(panelAtas);
        panelAtas.setLayout(panelAtasLayout);
        panelAtasLayout.setHorizontalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(LabPanelAtas)
                .addContainerGap(252, Short.MAX_VALUE))
        );
        panelAtasLayout.setVerticalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(LabPanelAtas)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        LabUsername.setText("Username");

        LabNamaUser.setText("Nama");

        TFUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFUsernameActionPerformed(evt);
            }
        });

        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("\t     \t\tWarning!!!\n1. Update Sandi Secara Berkala untuk menghindari peretasan .\n2.Gantilah sandi setiap beberapa bulan \n3.Jangan mendaur ulang sandi lama.\n4.gunakan sandi yg mudah di ingat ");
        WORD.setViewportView(jTextArea1);

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        Btnubah.setText("Ubah");
        Btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnubahActionPerformed(evt);
            }
        });

        Btnsimpan.setText("Simpan perubahan");
        Btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnsimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButPanelLayout = new javax.swing.GroupLayout(ButPanel);
        ButPanel.setLayout(ButPanelLayout);
        ButPanelLayout.setHorizontalGroup(
            ButPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Btnsimpan)
                .addGap(18, 18, 18)
                .addComponent(Btnubah, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ButPanelLayout.setVerticalGroup(
            ButPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButPanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(ButPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btnsimpan)
                    .addComponent(Btnubah)
                    .addComponent(btnbatal))
                .addGap(22, 22, 22))
        );

        LabPassSaIni.setText("Password Saat ini");

        LabKonfPass.setText("Konfirmasi Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(WORD, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelAtas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabNamaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabPassSaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabKonfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFUsername)
                                    .addComponent(TFNamaUser)
                                    .addComponent(Password, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(KonfPassword)
                                    .addComponent(ButPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAtas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabUsername)
                    .addComponent(TFUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabNamaUser)
                    .addComponent(TFNamaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabPassSaIni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KonfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabKonfPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WORD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setUserID(int userid){
        this.userID = userid;
    }


 // Tahap(1). Registrasi atau load driver
 private void tampilData() {
    int userId = userID;
    String query = "SELECT username, password, nama_depan, nama_belakang FROM users WHERE user_id = ?";
    
    try (PreparedStatement ps = koneksi.prepareStatement(query)) {
        // Set parameter untuk query
        ps.setInt(1, userId); // Menggunakan userId sebagai parameter
        ResultSet rs = ps.executeQuery();
        
        // Ambil data dan tampilkan ke JTextField
        if (rs.next()) {
            TFUsername.setText(rs.getString("username"));
            String namarah = rs.getString("nama_depan");
            String namarahi = rs.getString("nama_belakang");
            TFNamaUser.setText(namarah + " " + namarahi);
            Password.setText(rs.getString("password"));
            KonfPassword.setText(rs.getString("password"));
        } else {
            JOptionPane.showMessageDialog(this, "Data tidak ditemukan untuk ID: " + userId, "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error saat mengambil data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


// Fungsi untuk mendapatkan password dari database berdasarkan nama pengguna
private void ubahPassword() {
    int IDUser = userID;
    char[] passwordArray = Password.getPassword();
    String pass = new String(passwordArray);
    String query = "UPDATE users SET password = ? WHERE user_id = ?";
    try (PreparedStatement preparedStatement = koneksi.prepareStatement(query)) {
        // Set parameter
        preparedStatement.setString(1, pass);
        preparedStatement.setInt(2, IDUser);

        // Eksekusi query
        int rowsUpdated = preparedStatement.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Data berhasil diperbarui!");
        } else {
            System.out.println("Tidak ada data yang diperbarui.");
        }
    } catch (SQLException e) {
        System.err.print("Gagal ganti password" + e.getMessage());
    }
}

private void ubahUsername(){
    int IDUser = userID;
    String username = TFUsername.getText();
    String query = "UPDATE users SET username = ? WHERE user_id = ?";
    try (PreparedStatement preparedStatement = koneksi.prepareStatement(query)) {
        // Set parameter
        preparedStatement.setString(1, username);
        preparedStatement.setInt(2, IDUser);

        int rowsUpdated = preparedStatement.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Data berhasil diperbarui!");
        } else {
            System.out.println("Tidak ada data yang diperbarui.");
        }
    } catch (SQLException e) {
        System.err.print("Gagal ganti password" + e.getMessage());
    }
}

public boolean validasiInput() {
    // Validasi input lain, misalnya JTextField kosong
    char[] passwordArray = Password.getPassword();
    char[] passKonf = KonfPassword.getPassword();
    String pass = new String(passwordArray);
    String konfpass = new String(passKonf);
    if (TFUsername.getText().trim().isEmpty() || TFNamaUser.getText().trim().isEmpty() || pass.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Tidak boleh ada field kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return false;
    }

    if (pass.trim() == konfpass.trim()){
        JOptionPane.showMessageDialog(null, "Password tidak sama!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    return true;
}


    private void BtnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnsimpanActionPerformed
        if (!validasiInput()) {
            return; // Berhenti jika validasi gagal
        }
        ubahUsername();
        ubahPassword();
        btnbatalActionPerformed(evt);
        JOptionPane.showMessageDialog(this, "Login berhasil!");
    }//GEN-LAST:event_BtnsimpanActionPerformed

    private void BtnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnubahActionPerformed
        TFUsername.setEnabled(true);
        TFNamaUser.setEnabled(true);
        Password.setEnabled(true);
        KonfPassword.setEnabled(true);
        Btnsimpan.setEnabled(true);
        btnbatal.setEnabled(true);
        Btnubah.setEnabled(false);
        Btnsimpan.requestFocus();
    }//GEN-LAST:event_BtnubahActionPerformed

    private void TFUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFUsernameActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampilData();
        TFUsername.setEnabled(false);
        TFNamaUser.setEnabled(false);
        Password.setEnabled(false);
        KonfPassword.setEnabled(false);
        Btnsimpan.setEnabled(false);
        btnbatal.setEnabled(true);
        Btnubah.setEnabled(true);
    }//GEN-LAST:event_formWindowOpened

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
try {
        // Reset status field dan tombol
        TFUsername.setEnabled(false);
        TFNamaUser.setEnabled(false);
        Password.setEnabled(false);
        KonfPassword.setEnabled(false);

        // Nonaktifkan tombol simpan
        Btnsimpan.setEnabled(false);
        btnbatal.setEnabled(true);  // Tetap aktifkan tombol batal
        Btnubah.setEnabled(true);  // Aktifkan tombol ubah

        Btnubah.requestFocus();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnbatalActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized



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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UbahPassworddanUsername.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UbahPassworddanUsername.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UbahPassworddanUsername.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UbahPassworddanUsername.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UbahPassworddanUsername().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnsimpan;
    private javax.swing.JButton Btnubah;
    private javax.swing.JPanel ButPanel;
    private javax.swing.JPasswordField KonfPassword;
    private javax.swing.JLabel LabKonfPass;
    private javax.swing.JLabel LabNamaUser;
    private javax.swing.JLabel LabPanelAtas;
    private javax.swing.JLabel LabPassSaIni;
    private javax.swing.JLabel LabUsername;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField TFNamaUser;
    private javax.swing.JTextField TFUsername;
    private javax.swing.JScrollPane WORD;
    private javax.swing.JButton btnbatal;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel panelAtas;
    // End of variables declaration//GEN-END:variables

    private Object getPasswordFromDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
