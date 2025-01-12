package TA;

import java.awt.*;
import javax.swing.*;

public class LayoutHelper {
    private final GridBagConstraints gbc;

    public LayoutHelper() {
        gbc = new GridBagConstraints();
        // Konfigurasi default (bisa disesuaikan)
        gbc.insets = new Insets(5, 5, 5, 5); // Margin antar komponen
        gbc.fill = GridBagConstraints.HORIZONTAL;
    }

    // Metode untuk menambahkan komponen ke panel
    public void addComponent(JPanel panel, JComponent component, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        panel.add(component, gbc);
    }

    public void addComponent(JPanel panel, JComponent component, int x, int y, int gridwidth) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = gridwidth;
        panel.add(component, gbc);
    }

    public void setGridHeight(int gridheight) {
        gbc.gridheight = gridheight;
    }
    
    // Metode untuk mengatur konfigurasi tambahan (opsional)
    public void setInsets(int top, int left, int bottom, int right) {
        gbc.insets = new Insets(top, left, bottom, right);
    }

    public void setFill(int fill) {
        gbc.fill = fill;
    }

    public void setAnchor(int anchor) {
        gbc.anchor = anchor;
    }

    public void setWeightx(double  Weightx) {
        gbc.weightx = Weightx;
    }

    public void setWeighty(double Weighty) {
        gbc.weighty = Weighty;
    }
}