/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package S;
import javax.swing.*;
import java.awt.*;

public class CustomLayeredPanel extends JPanel {
    public CustomLayeredPanel() {
        // Set ukuran panel
        setLayout(new BorderLayout()); // Menggunakan BorderLayout untuk fleksibilitas
        setPreferredSize(new Dimension(600, 400));

        // Membuat JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null); // Menggunakan null layout untuk overlap

        // Panel latar belakang
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBounds(0, 0, 600, 400); // Ukuran penuh
        backgroundPanel.setLayout(null); // Tidak memerlukan layout
        ImageIcon backgroundIcon = new ImageIcon(CustomLayeredPanel.class.getResource("/TA.Foto/bg.png"));
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 600, 400);
        backgroundPanel.add(backgroundLabel);

        // Panel komponen
        JPanel componentPanel = new JPanel();
        componentPanel.setBounds(50, 50, 500, 300); // Ukuran lebih kecil dari background
        componentPanel.setLayout(null); // Menggunakan tata letak absolut untuk fleksibilitas
        componentPanel.setOpaque(false); // Membuat panel transparan agar latar belakang terlihat

        // Tambahkan komponen ke panel komponen
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

        componentPanel.add(titleLabel);
        componentPanel.add(nameLabel);
        componentPanel.add(nameField);
        componentPanel.add(phoneLabel);
        componentPanel.add(phoneField);
        componentPanel.add(addressLabel);
        componentPanel.add(addressField);

        // Menambahkan panel ke layeredPane
        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER); // Latar belakang di layer bawah
        layeredPane.add(componentPanel, JLayeredPane.PALETTE_LAYER); // Komponen di layer atas

        // Tambahkan layeredPane ke panel utama
        add(layeredPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Membuat JFrame untuk melihat hasil panel
        JFrame frame = new JFrame("Custom Layered Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Tambahkan CustomLayeredPanel ke frame
        CustomLayeredPanel customPanel = new CustomLayeredPanel();
        frame.add(customPanel);

        frame.setVisible(true);
    }
}
