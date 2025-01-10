package TA;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();

        while (true) { // Loop terus menerus
            if (login.getPermission()) { // Jika login berhasil
                System.out.println("Masuk");
                Front fr = new Front(true);
                DataHandler HAND = new DataHandler();
                UbahPassworddanUsername PASS = new UbahPassworddanUsername();

                new DataController(fr.getTabHandler(), HAND, PASS, login);

                break; // Keluar dari loop setelah login berhasil
            } else {
                login.setVisible(true); // Menampilkan form login
                System.out.println("Akses ditolak.");
            }
        }

        // Eksekusi setelah loop berhenti
        System.out.println("Program berlanjut...");
    }
}
