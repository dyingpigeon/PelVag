/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package S;

/**
 *
 * @author user
 */
import javax.swing.*;
import java.awt.*;


public class OverapPanelAndLabel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Overlap Panel and Label Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Membuat JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();

        // Membuat panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBounds(50, 50, 200, 100); // Posisi dan ukuran panel

        // Membuat label
        JLabel label = new JLabel("This is an overlapping label");
        label.setBounds(100, 80, 200, 50); // Posisi dan ukuran label
        label.setOpaque(true); // Agar latar belakang label terlihat
        label.setBackground(Color.YELLOW);

        // Menambahkan panel ke layeredPane pada layer lebih tinggi
        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER);

        // Menambahkan label ke layeredPane pada layer lebih rendah
        layeredPane.add(label, JLayeredPane.DEFAULT_LAYER);

        // Menambahkan layeredPane ke frame
        frame.add(layeredPane);
        frame.setVisible(true);
    }
}
