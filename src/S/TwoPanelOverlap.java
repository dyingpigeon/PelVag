/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package S;

import javax.swing.*;
import java.awt.*;

public class TwoPanelOverlap {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Two Panel Overlap Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(null); // Untuk memungkinkan overlap panel

        // Panel untuk background
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBounds(0, 0, 600, 400); // Menutupi seluruh frame
        backgroundPanel.setLayout(null); // Tidak memerlukan layout karena hanya background

        // Tambahkan JLabel sebagai latar belakang
        ImageIcon backgroundIcon = new ImageIcon(TwoPanelOverlap.class.getResource("/TA.Foto/bg.png"));
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 600, 400);
        backgroundPanel.add(backgroundLabel);

        // Panel untuk komponen
        JPanel componentPanel = new JPanel();
        componentPanel.setBounds(50, 50, 500, 300); // Ukuran lebih kecil dari background
        componentPanel.setLayout(null); // Menggunakan tata letak absolut untuk fleksibilitas
        componentPanel.setOpaque(false); // Membuat panel transparan agar background terlihat

        // Tambahkan komponen ke panel kedua
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

        // Tambahkan komponen ke panel komponen
        componentPanel.add(titleLabel);
        componentPanel.add(nameLabel);
        componentPanel.add(nameField);
        componentPanel.add(phoneLabel);
        componentPanel.add(phoneField);
        componentPanel.add(addressLabel);
        componentPanel.add(addressField);

        // Tambahkan kedua panel ke frame

        frame.add(componentPanel);
        frame.add(backgroundPanel);

        // Tampilkan frame
        frame.setVisible(true);
    }
}

