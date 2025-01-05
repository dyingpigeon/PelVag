package S;
import javax.swing.*;
import java.awt.*;

public class LayeredPanelExample {
    public static JPanel createLayeredPanel() {
        // Membuat panel utama
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(600, 400));

        // Membuat JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null); // Null layout untuk overlap

        // Panel latar belakang
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBounds(0, 0, 600, 400); // Ukuran penuh
        backgroundPanel.setLayout(null);
        ImageIcon backgroundIcon = new ImageIcon(LayeredPanelExample.class.getResource("/TA.Foto/bg.png"));
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 600, 400);
        backgroundPanel.add(backgroundLabel);

        // Panel komponen
        JPanel componentPanel = new JPanel();
        componentPanel.setBounds(50, 50, 500, 300); // Ukuran lebih kecil dari background
        componentPanel.setLayout(null); // Tata letak absolut untuk fleksibilitas
        componentPanel.setOpaque(false); // Membuat panel transparan agar background terlihat

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
        mainPanel.add(layeredPane, BorderLayout.CENTER);

        return mainPanel;
    }

    public static void main(String[] args) {
        // Membuat JFrame untuk melihat hasil
        JFrame frame = new JFrame("Layered Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Tambahkan layered panel ke frame
        frame.add(createLayeredPanel());

        frame.setVisible(true);
    }
}
