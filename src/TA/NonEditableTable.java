/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TA;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NonEditableTable {
    public static void main(String[] args) {
        // Data untuk tabel
        Object[][] data = {
            {"John", "Doe", 28},
            {"Jane", "Doe", 24},
            {"Sam", "Smith", 30}
        };
        
        // Nama kolom
        String[] columnNames = {"First Name", "Last Name", "Age"};
        
        // Membuat DefaultTableModel dan JTable
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Mengembalikan false untuk mencegah sel bisa diedit
                return false;
            }
        };
        
        JTable table = new JTable(model);
        
        // Menambahkan JTable ke dalam JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Menyiapkan JFrame
        JFrame frame = new JFrame("Non-Editable JTable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}
