package S;

import TA.LayoutHelper;
import java.awt.*;
import javax.swing.*;

public class LoginForm {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton;

    public LoginForm() {
        // Inisialisasi frame
        frame = new JFrame("Login Form");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel utama
        JPanel mainPanel = new JPanel(new GridBagLayout());
        LayoutHelper layoutHelper = new LayoutHelper();

        // Komponen
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");

        // Menambahkan komponen ke panel menggunakan LayoutHelper
        layoutHelper.addComponent(mainPanel, usernameLabel, 0, 0);
        layoutHelper.addComponent(mainPanel, usernameField, 1, 0);

        layoutHelper.addComponent(mainPanel, passwordLabel, 0, 1);
        layoutHelper.addComponent(mainPanel, passwordField, 1, 1);

        layoutHelper.addComponent(mainPanel, loginButton, 0, 2);
        layoutHelper.addComponent(mainPanel, cancelButton, 1, 2);

        // Listener untuk tombol
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if ("admin".equals(username) && "password".equals(password)) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
        });

        // Tambahkan panel ke frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginForm::new);
    }
}
