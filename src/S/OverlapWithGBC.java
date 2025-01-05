/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package S;

import javax.swing.*;
import java.awt.*;
public class OverlapWithGBC {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Overlap Panel and Label with GBC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Panel utama dengan GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Panel dasar untuk overlap
        JPanel overlapPanel = new JPanel(null); // Menggunakan null layout untuk overlap
        overlapPanel.setPreferredSize(new Dimension(300, 200));
        overlapPanel.setBackground(Color.LIGHT_GRAY);

        // Panel berwarna cyan
        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);
        cyanPanel.setBounds(50, 50, 200, 100); // Menentukan ukuran dan posisi relatif

        // Label berwarna kuning
        JLabel label = new JLabel("This is an overlapping label");
        label.setOpaque(true);
        label.setBackground(Color.YELLOW);
        label.setBounds(100, 80, 200, 50); // Menentukan ukuran dan posisi relatif

        // Menambahkan komponen ke panel overlap
        overlapPanel.add(cyanPanel);
        overlapPanel.add(label);

        // Menambahkan overlapPanel ke GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(overlapPanel, gbc);

        // Menambahkan mainPanel ke frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}

