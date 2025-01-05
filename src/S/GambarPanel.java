package S;

import javax.swing.*;
import java.awt.*;

public class GambarPanel extends JPanel {
    private Image backgroundImage;

    // Konstruktor untuk memuat gambar dari file
    public GambarPanel() {
        // Memuat gambar menggunakan getClass().getResource
        backgroundImage = new ImageIcon("TA.Foto/bg.png").getImage();
    }

    // Override metode paintComponent untuk menggambar gambar di panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Menggambar gambar sebagai background
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}