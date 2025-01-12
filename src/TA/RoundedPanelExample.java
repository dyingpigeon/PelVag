/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TA;

/**
 *
 * @author user
 */
import javax.swing.*;
import java.awt.*;

public class RoundedPanelExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rounded Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Panel dengan sudut melingkar
        RoundedPanel myPanel = new RoundedPanel(20); // Sudut melingkar 20 piksel
        myPanel.setBackground(Color.LIGHT_GRAY); // Warna latar belakang
        myPanel.setLayout(new FlowLayout()); // Tata letak dalam panel

        // Tambahkan komponen ke panel
        myPanel.add(new JLabel("Ini adalah panel dengan sudut melingkar."));
        myPanel.add(new JButton("Tombol"));

        // Tambahkan panel ke frame
        frame.add(myPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
