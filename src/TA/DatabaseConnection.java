package TA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/songket_tubes"; // URL database
    private static final String USER = "root"; // Username database, default XAMPP adalah root
    private static final String PASSWORD = ""; // Password database, default XAMPP adalah kosong

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi ke database berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi ke database gagal!");
            e.printStackTrace();
            throw e;
        }
        return connection;
    }
}
