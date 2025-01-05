/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package S;

import javax.swing.*;
import java.awt.*;

public class PanelWithBackground {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel with Background Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Panel Penerima dengan layout null
        JPanel panelPenerima = new JPanel();
        panelPenerima.setLayout(null); // Untuk overlap manual
        panelPenerima.setPreferredSize(new Dimension(500, 300));

        // Tambahkan JLabel sebagai background
        ImageIcon backgroundIcon = new ImageIcon(PanelWithBackground.class.getResource("/TA.Foto/bg.png"));
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 500, 300); // Pastikan ukuran sesuai dengan panel

        // Tambahkan komponen lain ke panelPenerima
        JLabel titleLabel = new JLabel("Data Diri Penerima");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(150, 20, 200, 30);

        JLabel nameLabel = new JLabel("Nama:");
        nameLabel.setBounds(50, 80, 100, 30);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 80, 200, 30);

        JLabel phoneLabel = new JLabel("Nomor Telepon:");
        phoneLabel.setBounds(50, 120, 100, 30);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(150, 120, 200, 30);

        JLabel addressLabel = new JLabel("Alamat:");
        addressLabel.setBounds(50, 160, 100, 30);

        JTextField addressField = new JTextField();
        addressField.setBounds(150, 160, 200, 30);

        // Tambahkan komponen ke panelPenerima
        panelPenerima.add(titleLabel);
        panelPenerima.add(nameLabel);
        panelPenerima.add(nameField);
        panelPenerima.add(phoneLabel);
        panelPenerima.add(phoneField);
        panelPenerima.add(addressLabel);
        panelPenerima.add(addressField);
                panelPenerima.add(backgroundLabel); // Tambahkan background terlebih dahulu
        panelPenerima.setComponentZOrder(backgroundLabel, panelPenerima.getComponentCount() - 1); // Pastikan background di bawah


        // Tambahkan panelPenerima ke frame
        frame.add(panelPenerima, BorderLayout.CENTER);

        // Tampilkan frame
        frame.pack();
        frame.setVisible(true);
    }
}
