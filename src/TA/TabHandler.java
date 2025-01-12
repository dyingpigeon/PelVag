package TA;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class TabHandler {
    private JTextField TFNama;
    private JTextField TFNotlp;
    private JTextField TFAlamat;
    private DefaultTableModel modelStok;
    private JComboBox<Data> ekspedisiCombo;
    private JComboBox<Data> songketCombo;
    private JComboBox<Data> warnaCombo;
    private JComboBox<Data> bahanCombo;
    private JComboBox<Data> karyawanCombo;
    private JSpinner spinnerJumlah;
    private Connection connection;
    private DefaultTableModel tabelPesananSaatIni;
    private DefaultTableModel tabelModelDetailPesanan;
    private DefaultTableModel tabelModelPesanan;
    private DefaultTableModel tabelModelPesananNoID;
    private int idCounterKaryawan;
    private int idCounterSongket;
    private int idCounterBahan;
    private int idCounterWarna;
    private int idCounterEkspedisi;
    private int idPesanan;
    private int idDetailPesanan;
    private JButton butUpload;
    private JButton butSimpan;
    private JButton butSimUp;    
    private JButton butTamb;        
    private JTable tabelPesanan;
    private JTable tabelPesananNoID;
    private JButton butUbahPesanan;
    private JButton butHapusPesanan;
    private JButton butBatalPesanan;
    private JButton butHapusSemua;
    private JButton butAkun;
    private JButton butRefresh;

    // --------------
    private DefaultTableModel modelSongket;
    private DefaultTableModel modelBahan;
    private DefaultTableModel modelWarna;
    private DefaultTableModel modelEkspedisi;
    private DefaultTableModel modelSementara;
    private JTable tabelSongket;
    private JTable tabelWarna;
    private JTable tabelBahan;
    private JTable tabelEkspedisi;
    private JTextField TF;
    private JButton btnUbah;
    private JButton btnHapus;
    private JButton btnTambah;
    private JComboBox<String> Combo;

    // -------------------
    private int a;
    private int b;
    private int c;
    private int d;





    

    public TabHandler(){
        String[] headerStok = {"Songket", "Harga", "Stok"};
        this.modelStok = new DefaultTableModel(headerStok, 0);
        this.TFNama = new JTextField(25);
        this.TFNotlp = new JTextField(25);
        this.TFAlamat = new JTextField(25);
        this.ekspedisiCombo = new JComboBox<>();
        this.songketCombo = new JComboBox<>();
        this.warnaCombo = new JComboBox<>();
        this.bahanCombo = new JComboBox<>();
        this.karyawanCombo = new JComboBox<>();
        this.spinnerJumlah = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        String[] headerDetailPesanan = {"Jenis Songket", "Bahan", "Warna", "Jumlah"};
        String[] headerPesanan = {"Detail_Pesanan_ID", "PesananID", "Penerima", "No. Telepon", "Alamat", "Ekspedisi", "Songket", "Bahan", "Warna", "Jumlah"};

        this.tabelPesananSaatIni = new DefaultTableModel(headerDetailPesanan, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tabelModelDetailPesanan = new DefaultTableModel(headerDetailPesanan, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tabelModelPesanan = new DefaultTableModel(headerPesanan, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.tabelModelPesananNoID = new DefaultTableModel(headerPesanan, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.tabelPesanan = new JTable(tabelModelPesanan);
        this.tabelPesananNoID = new JTable(tabelModelPesananNoID);
        this.butUpload = new JButton("Upload");
        this.butSimpan = new JButton("Simpan");
        this.butSimUp = new JButton("Simpan dan Upload");    
        this.butTamb = new JButton("Tambah Songket");

        this.idCounterKaryawan = 100001;
        this.idCounterSongket = 200001;
        this.idCounterBahan = 300001;
        this.idCounterWarna = 400001;
        this.idCounterEkspedisi = 500001;

        this.butUbahPesanan = new JButton("Ubah");
        this.butUbahPesanan.setPreferredSize(new Dimension(100, 30));
        this.butHapusPesanan = new JButton("Hapus");
        this.butHapusPesanan.setPreferredSize(new Dimension(100, 30));
        this.butBatalPesanan = new JButton("Batal");
        this.butBatalPesanan.setPreferredSize(new Dimension(100, 30));
        this.butHapusSemua = new JButton("HapusPesanan");
        this.butHapusSemua.setPreferredSize(new Dimension(100, 30));
        this.butAkun = new JButton("Informasi Akun");
        this.butAkun.setPreferredSize(new Dimension(100, 30));
        this.butRefresh = new JButton("Refresh");
        this.butRefresh.setPreferredSize(new Dimension(100, 30));

        this.modelSongket = new DefaultTableModel(new String[] {"Songket"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.modelBahan = new DefaultTableModel(new String[] {"Bahan"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.modelEkspedisi = new DefaultTableModel(new String[] {"Ekspedisi"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.modelWarna = new DefaultTableModel(new String[] {"Warna"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.modelSementara = new DefaultTableModel(new String[] {"Sementara"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.tabelSongket = new JTable(modelSongket);
        this.tabelWarna = new JTable(modelWarna);
        this.tabelBahan = new JTable(modelBahan);
        this.tabelEkspedisi = new JTable(modelEkspedisi);

        this.btnUbah = new JButton("Ubah");
        this.btnHapus = new JButton("Hapus");
        this.btnTambah = new JButton("Tambah");

        this.TF = new JTextField();
        this.Combo = new JComboBox<>();

        try {
            // Memanggil koneksi hanya sekali ketika objek Utama dibuat
            this.connection = DatabaseConnection.getConnection();
            System.out.println("Koneksi berhasil!");
        } catch (SQLException e) {
            System.err.println("Gagal terhubung ke database: " + e.getMessage());
        }
    }

    public JTabbedPane createTabs() {
        JTabbedPane tabbedPane = new JTabbedPane();

        data();
        loadData();
        setPallete1();

        JPanel tab1 = createTab1();
        JPanel tab2 = createTab2();
        JPanel tab3 = createTab3();

        tabbedPane.addTab("Buat Order", tab1);
        tabbedPane.addTab("Ubah Order", tab2);
        tabbedPane.addTab("e-commerce", tab3);

        return tabbedPane;
    }
    // ------------------------------------------------------------------
    // private void setupTableModels() {
    //     // Setup model tabel untuk Songket
    //     modelSongket = (DefaultTableModel) tabelSongket.getModel();
    //     modelSongket.setColumnIdentifiers(new String[]{"Songket"});

    //     // Setup model tabel untuk Bahan
    //     modelBahan = (DefaultTableModel) tabelBahan.getModel();
    //     modelBahan.setColumnIdentifiers(new String[]{"Bahan"});

    //     // Setup model tabel untuk Warna
    //     modelWarna = (DefaultTableModel) tabelWarna.getModel();
    //     modelWarna.setColumnIdentifiers(new String[]{"Warna"});

    //     // Setup model tabel untuk Ekspedisi
    //     modelEkspedisi = (DefaultTableModel) tabelEkspedisi.getModel();
    //     modelEkspedisi.setColumnIdentifiers(new String[]{"Ekspedisi"});
    // }

    private void data(){
        this.Combo.addItem("Songket");
        this.Combo.addItem("Bahan");
        this.Combo.addItem("Warna");
        this.Combo.addItem("Ekspedisi");

        String[][] queries = {
            {"select nama from songket", "Songket"},
            {"select nama from warna", "Warna"},
            {"select nama from bahan", "Bahan"},
            {"select nama from ekspedisi", "Ekspedisi"}
        };
        
        try {
            for (String[] queryData : queries) {
                String query = queryData[0];
                String comboType = queryData[1];
        
                try (PreparedStatement ps = connection.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String nama = rs.getString("nama");
                        switch (comboType) {
                            case "Songket" -> addDataToSongket(nama);
                            case "Warna" -> addDataToWarna(nama);
                            case "Bahan" -> addDataToBahan(nama);
                            case "Ekspedisi" -> addDataToEkspedisi(nama);
                        }
                    }
                }
            }
        }catch (SQLException e) {
            System.err.println("Gagal memasukkan data ke combo atau tabel: " + e.getMessage());
        }
    }

    private void addDataToSongket(String isi){
        modelSongket.addRow(new Object[]{isi});
    }
    
    private void addDataToBahan(String isi){
        modelBahan.addRow(new Object[]{isi});
    }

    private void addDataToWarna(String isi){
        modelWarna.addRow(new Object[]{isi});
    }

    private void addDataToEkspedisi(String isi){
        modelEkspedisi.addRow(new Object[]{isi});
    }

    private void addDataToSementara(String isi){
        modelSementara.addRow(new Object[]{isi});
    }

    private void handleTableClick(String selectedCategory) {
        int selectedRow;
        switch (selectedCategory) {
            case "Songket" -> {
                selectedRow = tabelSongket.getSelectedRow();
                TF.setText(tabelSongket.getValueAt(selectedRow, 0).toString());
            }
            case "Bahan" -> {
                selectedRow = tabelBahan.getSelectedRow();
                TF.setText(tabelBahan.getValueAt(selectedRow, 0).toString());
            }
            case "Warna" -> {
                selectedRow = tabelWarna.getSelectedRow();
                TF.setText(tabelWarna.getValueAt(selectedRow, 0).toString());
            }
            case "Ekspedisi" -> {
                selectedRow = tabelEkspedisi.getSelectedRow();
                TF.setText(tabelEkspedisi.getValueAt(selectedRow, 0).toString());
            }
        }
    }

    private void setPallete1(){
        this.a = new Color(254, 249, 225).getRGB();
        this.b = new Color(229, 208, 172).getRGB();
        this.c = new Color(163, 29, 29).getRGB();
        this.d = new Color(109, 35, 35).getRGB();
    }

    private void updateIsi(String pilih) {
        int selectedRow;
        String isi = TF.getText();
        switch (pilih) {
            case "Songket" -> {
                selectedRow = tabelSongket.getSelectedRow();
                String query1 = "UPDATE songket SET nama = ? WHERE nama = ?";
                try (PreparedStatement stmt = connection.prepareStatement(query1)) {
                    stmt.setString(1, isi);
                    stmt.setString(2, tabelSongket.getValueAt(selectedRow, 0).toString());
                    stmt.executeUpdate();
                }catch (SQLException e) {
                    System.err.println("Gagal memperbarui data detail pesanan: " + e.getMessage());
                }
            }
            case "Bahan" -> {
                selectedRow = tabelBahan.getSelectedRow();
                String query1 = "UPDATE bahan SET nama = ? WHERE nama = ?";
                try (PreparedStatement stmt = connection.prepareStatement(query1)) {
                    stmt.setString(1, isi);
                    stmt.setString(2, tabelBahan.getValueAt(selectedRow, 0).toString());
                    stmt.executeUpdate();
                }catch (SQLException e) {
                    System.err.println("Gagal memperbarui data detail pesanan: " + e.getMessage());
                }
            }
            case "Warna" -> {
                selectedRow = tabelWarna.getSelectedRow();
                String query1 = "UPDATE warna SET nama = ? WHERE nama = ?";
                try (PreparedStatement stmt = connection.prepareStatement(query1)) {
                    stmt.setString(1, isi);
                    stmt.setString(2, tabelWarna.getValueAt(selectedRow, 0).toString());
                    stmt.executeUpdate();
                }catch (SQLException e) {
                    System.err.println("Gagal memperbarui data detail pesanan: " + e.getMessage());
                }
            }
            case "Ekspedisi" -> {
                selectedRow = tabelEkspedisi.getSelectedRow();
                String query1 = "UPDATE ekspedisi SET nama = ? WHERE nama = ?";
                try (PreparedStatement stmt = connection.prepareStatement(query1)) {
                    stmt.setString(1, isi);
                    stmt.setString(2, tabelEkspedisi.getValueAt(selectedRow, 0).toString());
                    stmt.executeUpdate();
                }catch (SQLException e) {
                    System.err.println("Gagal memperbarui data detail pesanan: " + e.getMessage());
                }
            }
        }
    }

    private void tambah(String pilih) {
        String isi = TF.getText();
        switch (pilih) {
            case "Songket" -> {
                String query1 = "INSERT INTO songket (nama) VALUES (?)";
                try (PreparedStatement stmt = connection.prepareStatement(query1)) {
                    stmt.setString(1, isi);
                    stmt.executeUpdate();
                    System.out.println("Data berhasil ditambahkan ke tabel Songket.");
                } catch (SQLException e) {
                    System.err.println("Gagal menambahkan data ke tabel Songket: " + e.getMessage());
                }
            }
            case "Bahan" -> {
                String query1 = "INSERT INTO bahan (nama) VALUES (?)";
                try (PreparedStatement stmt = connection.prepareStatement(query1)) {
                    stmt.setString(1, isi);
                    stmt.executeUpdate();
                    System.out.println("Data berhasil ditambahkan ke tabel Bahan.");
                } catch (SQLException e) {
                    System.err.println("Gagal menambahkan data ke tabel Bahan: " + e.getMessage());
                }
            }
            case "Warna" -> {
                String query1 = "INSERT INTO warna (nama) VALUES (?)";
                try (PreparedStatement stmt = connection.prepareStatement(query1)) {
                    stmt.setString(1, isi);
                    stmt.executeUpdate();
                    System.out.println("Data berhasil ditambahkan ke tabel Warna.");
                } catch (SQLException e) {
                    System.err.println("Gagal menambahkan data ke tabel Warna: " + e.getMessage());
                }
            }
            case "Ekspedisi" -> {
                String query1 = "INSERT INTO ekspedisi (nama) VALUES (?)";
                try (PreparedStatement stmt = connection.prepareStatement(query1)) {
                    stmt.setString(1, isi);
                    stmt.executeUpdate();
                    System.out.println("Data berhasil ditambahkan ke tabel Ekspedisi.");
                } catch (SQLException e) {
                    System.err.println("Gagal menambahkan data ke tabel Ekspedisi: " + e.getMessage());
                }
            }
        }
    }

    private void Hapus(String pilih) {
        int selectedRow;
        switch (pilih) {
            case "Songket" -> {
                selectedRow = tabelSongket.getSelectedRow();
                String query1 = "delete from songket WHERE nama = ?";
                try (PreparedStatement stmt = connection.prepareStatement(query1)) {
                    stmt.setString(1, tabelSongket.getValueAt(selectedRow, 0).toString());
                    stmt.executeUpdate();
                }catch (SQLException e) {
                    System.err.println("Gagal menghapus data: " + e.getMessage());
                }
            }
            case "Bahan" -> {
                selectedRow = tabelBahan.getSelectedRow();
                System.out.println(tabelBahan.getValueAt(selectedRow, 0).toString());
                String query1 = "delete from bahan WHERE nama = ?";
                try (PreparedStatement stmt = connection.prepareStatement(query1)) {
                    stmt.setString(1, tabelBahan.getValueAt(selectedRow, 0).toString());
                    stmt.executeUpdate();
                }catch (SQLException e) {
                    System.err.println("Gagal menghapus data: " + e.getMessage());
                }
            }
            case "Warna" -> {
                selectedRow = tabelWarna.getSelectedRow();
                String query1 = "delete from warna WHERE nama = ?";
                try (PreparedStatement stmt = connection.prepareStatement(query1)) {
                    stmt.setString(1, tabelWarna.getValueAt(selectedRow, 0).toString());
                    stmt.executeUpdate();
                }catch (SQLException e) {
                    System.err.println("Gagal menghapus data: " + e.getMessage());
                }
            }
            case "Ekspedisi" -> {
                selectedRow = tabelEkspedisi.getSelectedRow();
                String query1 = "delete from ekspedisi WHERE nama = ?";
                try (PreparedStatement stmt = connection.prepareStatement(query1)) {
                    stmt.setString(1, tabelEkspedisi.getValueAt(selectedRow, 0).toString());
                    stmt.executeUpdate();
                }catch (SQLException e) {
                    System.err.println("Gagal menghapus data: " + e.getMessage());
                }
            }
        }
        refreshDatabase(pilih);
    }

    private void refreshDatabase(String pilih) {
        switch (pilih) {
            case "Ekspedisi" -> {
                String ambilData = "SELECT nama FROM ekspedisi";
                String queryTruncate = "TRUNCATE TABLE ekspedisi";
                String queryInsert = "INSERT INTO ekspedisi (ekspedisi_id, nama) VALUES (?, ?)";
                String queryInsertNama = "INSERT INTO ekspedisi (nama) VALUES (?)";
        
                try {
                    // Ambil data dari tabel ekspedisi dan masukkan ke tabel sementara
                    try (PreparedStatement ps = connection.prepareStatement(ambilData)) {
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            String nama = rs.getString("nama");
                            addDataToSementara(nama);
                        }
                    }
        
                    // Truncate tabel ekspedisi
                    try (PreparedStatement psTruncate = connection.prepareStatement(queryTruncate)) {
                        psTruncate.executeUpdate();
                    }
        
                    // Insert data baru ke ekspedisi
                    try (PreparedStatement stmt = connection.prepareStatement(queryInsert)) {
                        stmt.setInt(1, 500001); // Contoh ID
                        stmt.setString(2, modelSementara.getValueAt(0, 0).toString());
                        stmt.executeUpdate();
                    }
        
                    // Insert data tambahan ke ekspedisi
                    for (int i = 1; i < modelSementara.getRowCount(); i++) {
                        try (PreparedStatement psInsertNama = connection.prepareStatement(queryInsertNama)) {
                            psInsertNama.setString(1, modelSementara.getValueAt(i, 0).toString());
                            psInsertNama.executeUpdate();
                        }
                    }
                } catch (SQLException e) {
                    System.err.println("Error: " + e.getMessage());
                }
                modelSementara.setRowCount(0);
            }
            case "Songket" -> {
                String ambilData = "SELECT nama FROM songket";
                String queryTruncate = "TRUNCATE TABLE songket";
                String queryInsert = "INSERT INTO songket (songket_id, nama) VALUES (?, ?)";
                String queryInsertNama = "INSERT INTO songket (nama) VALUES (?)";
        
                try {
                    // Ambil data dari tabel songket dan masukkan ke tabel sementara
                    try (PreparedStatement ps = connection.prepareStatement(ambilData)) {
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            String nama = rs.getString("nama");
                            addDataToSementara(nama);
                        }
                    }
        
                    // Truncate tabel songket
                    try (PreparedStatement psTruncate = connection.prepareStatement(queryTruncate)) {
                        psTruncate.executeUpdate();
                    }
        
                    // Insert data baru ke songket
                    try (PreparedStatement stmt = connection.prepareStatement(queryInsert)) {
                        stmt.setInt(1, 200001); // Contoh ID
                        stmt.setString(2, modelSementara.getValueAt(0, 0).toString());
                        stmt.executeUpdate();
                    }
        
                    // Insert data tambahan ke songket
                    for (int i = 1; i < modelSementara.getRowCount(); i++) {
                        try (PreparedStatement psInsertNama = connection.prepareStatement(queryInsertNama)) {
                            psInsertNama.setString(1, modelSementara.getValueAt(i, 0).toString());
                            psInsertNama.executeUpdate();
                        }
                    }
                } catch (SQLException e) {
                    System.err.println("Error: " + e.getMessage());
                }
                modelSementara.setRowCount(0);
            }
            case "Bahan" -> {
                String ambilData = "SELECT nama FROM bahan";
                String queryTruncate = "TRUNCATE TABLE bahan";
                String queryInsert = "INSERT INTO bahan (bahan_id, nama) VALUES (?, ?)";
                String queryInsertNama = "INSERT INTO bahan (nama) VALUES (?)";
        
                try {
                    // Ambil data dari tabel bahan dan masukkan ke tabel sementara
                    try (PreparedStatement ps = connection.prepareStatement(ambilData)) {
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            String nama = rs.getString("nama");
                            addDataToSementara(nama);
                        }
                    }
        
                    // Truncate tabel bahan
                    try (PreparedStatement psTruncate = connection.prepareStatement(queryTruncate)) {
                        psTruncate.executeUpdate();
                    }
        
                    // Insert data baru ke bahan
                    try (PreparedStatement stmt = connection.prepareStatement(queryInsert)) {
                        stmt.setInt(1, 300001); // Contoh ID
                        stmt.setString(2, modelSementara.getValueAt(0, 0).toString());
                        stmt.executeUpdate();
                    }
        
                    // Insert data tambahan ke bahan
                    for (int i = 1; i < modelSementara.getRowCount(); i++) {
                        try (PreparedStatement psInsertNama = connection.prepareStatement(queryInsertNama)) {
                            psInsertNama.setString(1, modelSementara.getValueAt(i, 0).toString());
                            psInsertNama.executeUpdate();
                        }
                    }
                } catch (SQLException e) {
                    System.err.println("Error: " + e.getMessage());
                }
                modelSementara.setRowCount(0);
            }
            case "Warna" -> {
                String ambilData = "SELECT nama FROM warna";
                String queryTruncate = "TRUNCATE TABLE warna";
                String queryInsert = "INSERT INTO warna (warna_id, nama) VALUES (?, ?)";
                String queryInsertNama = "INSERT INTO warna (nama) VALUES (?)";
        
                try {
                    // Ambil data dari tabel warna dan masukkan ke tabel sementara
                    try (PreparedStatement ps = connection.prepareStatement(ambilData)) {
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            String nama = rs.getString("nama");
                            addDataToSementara(nama);
                        }
                    }
        
                    // Truncate tabel warna
                    try (PreparedStatement psTruncate = connection.prepareStatement(queryTruncate)) {
                        psTruncate.executeUpdate();
                    }
                    // Insert data baru ke warna
                    try (PreparedStatement stmt = connection.prepareStatement(queryInsert)) {
                        stmt.setInt(1, 400001); // Contoh ID
                        stmt.setString(2, modelSementara.getValueAt(0, 0).toString());
                        stmt.executeUpdate();
                    }
        
                    // Insert data tambahan ke warna
                    for (int i = 1; i < modelSementara.getRowCount(); i++) {
                        try (PreparedStatement psInsertNama = connection.prepareStatement(queryInsertNama)) {
                            psInsertNama.setString(1, modelSementara.getValueAt(i, 0).toString());
                            psInsertNama.executeUpdate();
                        }
                    }
                } catch (SQLException e) {
                    System.err.println("Error: " + e.getMessage());
                }
                modelSementara.setRowCount(0);
            }
        }        
    }
    // ------------------------------------------------------------------

    private void addDataToCombo(JComboBox<Data> combo, int id, String isi){
        combo.addItem(new Data(id, isi));
    }

    private void addDataToTable(String songket, String harga) {
        modelStok.addRow(new Object[]{songket, harga}); // Tambahkan data ke model
    }

    private void addDataToTable(int id, int ID, String penerima, String telepon, String alamat, 
                                int IDekspedisi, int IDsongket, int IDbahan, int IDwarna,
                                int jumlah){
        tabelModelPesanan.addRow(new Object[]{id, ID, penerima, telepon, alamat, 
                                IDekspedisi, IDsongket, IDbahan, IDwarna, 
                                jumlah});
                                }

    private void addDataToTable(int id, int ID, String penerima, String telepon, String alamat, 
                                String IDekspedisi, String IDsongket, String IDbahan, String IDwarna,
                                int jumlah){
        tabelModelPesananNoID.addRow(new Object[]{id, ID, penerima, telepon, alamat, 
                                IDekspedisi, IDsongket, IDbahan, IDwarna, 
                                jumlah});
                                }

    private void loadData() {
        String[][] queries = {
            {"select nama from songket", "Songket"},
            {"select nama from warna", "Warna"},
            {"select nama from bahan", "Bahan"},
            {"select nama from karyawan", "Karyawan"},
            {"select nama from ekspedisi", "Ekspedisi"}
        };

        try {
            for (String[] queryData : queries) {
                String query = queryData[0];
                String comboType = queryData[1];
        
                try (PreparedStatement ps = connection.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String nama = rs.getString("nama");
                        switch (comboType) {
                            case "Songket" -> addDataToCombo(songketCombo, idCounterSongket++, nama);
                            case "Warna" -> addDataToCombo(warnaCombo, idCounterWarna++, nama);
                            case "Bahan" -> addDataToCombo(bahanCombo, idCounterBahan++, nama);
                            case "Karyawan" -> addDataToCombo(karyawanCombo, idCounterKaryawan++, nama);
                            case "Ekspedisi" -> addDataToCombo(ekspedisiCombo, idCounterEkspedisi++, nama);
                        }
                    }
                }
            }
        
            String walawe = "SELECT nama, harga FROM songket"; // Sesuaikan query
            try (PreparedStatement ps = connection.prepareStatement(walawe);
                ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String menu = rs.getString("nama");
                    String harga = rs.getString("harga");
                    addDataToTable(menu, harga); // Method untuk menambahkan ke tabel
                }
            }

            String Walah = """
                            SELECT 
                                pesanan.pesanan_id,
                                pesanan.ekspedisi_id,
                                pesanan.penerima,
                                pesanan.telepon,
                                pesanan.alamat,
                                detail_pesanan.detail_pesanan_id,
                                detail_pesanan.songket_id,
                                detail_pesanan.bahan_id,
                                detail_pesanan.warna_id,
                                detail_pesanan.jumlah
                            FROM 
                                pesanan
                            JOIN 
                                detail_pesanan 
                            ON 
                                pesanan.pesanan_id = detail_pesanan.pesanan_id;
                            """;
            try (PreparedStatement ps = connection.prepareStatement(Walah);
            ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    // Mengambil data dari ResultSet
                    int detailpesananid = rs.getInt("detail_pesanan_id");
                    int pesananid = rs.getInt("pesanan_id");
                    int ekspedisiId = rs.getInt("ekspedisi_id");
                    String penerima = rs.getString("penerima");
                    String telepon = rs.getString("telepon");
                    String alamat = rs.getString("alamat");
                    int songketId = rs.getInt("songket_id");
                    int bahanId = rs.getInt("bahan_id");
                    int warnaId = rs.getInt("warna_id");
                    int jumlah = rs.getInt("jumlah");

                    // Menambahkan data ke DefaultTableModel
                    addDataToTable(detailpesananid, pesananid, penerima, telepon, alamat, ekspedisiId, songketId, bahanId, warnaId, jumlah);
                }

            } 

            String Walahi = """
                            SELECT 
                                pesanan.pesanan_id,
                                ekspedisi.nama AS nama_ekspedisi,
                                pesanan.penerima,
                                pesanan.telepon,
                                pesanan.alamat,
                                detail_pesanan.detail_pesanan_id,
                                songket.nama AS nama_songket,
                                bahan.nama AS nama_bahan,
                                warna.nama AS nama_warna,
                                detail_pesanan.jumlah
                            FROM 
                                pesanan
                            JOIN 
                                detail_pesanan ON pesanan.pesanan_id = detail_pesanan.pesanan_id
                            JOIN 
                                ekspedisi ON pesanan.ekspedisi_id = ekspedisi.ekspedisi_id
                            JOIN 
                                songket ON detail_pesanan.songket_id = songket.songket_id
                            JOIN 
                                bahan ON detail_pesanan.bahan_id = bahan.bahan_id
                            JOIN 
                                warna ON detail_pesanan.warna_id = warna.warna_id
                            ORDER BY 
                                pesanan.pesanan_id, detail_pesanan.detail_pesanan_id;
                            """;
            try (PreparedStatement ps = connection.prepareStatement(Walahi);
            ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    // Mengambil data dari ResultSet
                    int detailpesananid = rs.getInt("detail_pesanan_id");
                    int pesananid = rs.getInt("pesanan_id");
                    String ekspedisiId = rs.getString("nama_ekspedisi");
                    String penerima = rs.getString("penerima");
                    String telepon = rs.getString("telepon");
                    String alamat = rs.getString("alamat");
                    String songketId = rs.getString("nama_songket");
                    String bahanId = rs.getString("nama_bahan");
                    String warnaId = rs.getString("nama_warna");
                    int jumlah = rs.getInt("jumlah");

                    // Menambahkan data ke DefaultTableModel
                    addDataToTable(detailpesananid, pesananid, penerima, telepon, alamat, ekspedisiId, songketId, bahanId, warnaId, jumlah);
                }

            } 
        } catch (SQLException e) {
            System.err.println("Gagal memasukkan data ke combo atau tabel: " + e.getMessage());
        }
        
    }

    public void setComboBoxById(JComboBox<Data> comboBox, int id) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            Data data = comboBox.getItemAt(i);
            if (data.getId() == id) {
                comboBox.setSelectedIndex(i);
                return; // Keluar dari metode setelah menemukan kecocokan
            }
        }
        // Jika tidak ditemukan, Anda bisa memilih untuk tidak melakukan apa-apa atau memberikan log
        System.out.println("ID tidak ditemukan: " + id);
    }

    private void handleTableClick(MouseEvent e, JTable tabel) {
        int selectedRow = tabel.getSelectedRow();
        TFNama.setText(tabelModelPesanan.getValueAt(selectedRow, 2).toString());
        TFNotlp.setText(tabelModelPesanan.getValueAt(selectedRow, 3).toString());
        TFAlamat.setText(tabelModelPesanan.getValueAt(selectedRow, 4).toString());

        setComboBoxById(ekspedisiCombo, Integer.parseInt(tabelModelPesanan.getValueAt(selectedRow, 5).toString()));
        setComboBoxById(songketCombo, Integer.parseInt(tabelModelPesanan.getValueAt(selectedRow, 6).toString()));
        setComboBoxById(bahanCombo, Integer.parseInt(tabelModelPesanan.getValueAt(selectedRow, 7).toString()));
        setComboBoxById(warnaCombo, Integer.parseInt(tabelModelPesanan.getValueAt(selectedRow, 8).toString()));
        

        spinnerJumlah.setValue(tabelModelPesanan.getValueAt(selectedRow, 9));

        System.out.println(selectedRow);
        // Mendapatkan indeks baris dan kolom yang diklik
        int row = tabel.rowAtPoint(e.getPoint()); // Mendapatkan baris yang diklik
        int column = 0; // Mendapatkan kolom yang diklik
        int column1 = 1; // Mendapatkan kolom yang diklik

        // Cek jika baris yang diklik valid
        if (row >= 0 && column >= 0) {
            // Mendapatkan data dari tabel berdasarkan baris dan kolom yang diklik
            Object cellValue = tabel.getValueAt(row, column1);

            // Jika nilai tersebut dapat dikonversi menjadi Integer
            if (cellValue != null) {
                try {
                    this.idPesanan = Integer.parseInt(cellValue.toString());
                    this.idDetailPesanan = Integer.parseInt(tabel.getValueAt(row, 0).toString());
                    // Lakukan sesuatu dengan parsedValue, misalnya mencetaknya
                    System.out.println("Nilai yang diklik: " + idPesanan);
                    System.out.println("Nilai yang diklik: " + idDetailPesanan);
                } catch (NumberFormatException ex) {
                    System.out.println("Nilai yang diklik bukan angka");
                }
            }
        }
    }
    

    private void toggleVisibility(JPanel panel, JPanel inside, JPanel outside){
        boolean currentVisibility = inside.isVisible();
            
        outside.setVisible(false);
        inside.setVisible(false);
        
        if (!currentVisibility) {
            inside.setVisible(true);
        } else {
            outside.setVisible(true);
            kosongkan();
        }
    
        panel.revalidate();
        panel.repaint();
    }

    private JPanel createTab1() {
        JPanel tab = new JPanel(new BorderLayout());
        tab.setBackground(new Color(d));

        JPanel panelPenerima = new JPanel(new GridBagLayout());
        panelPenerima.setBackground(new Color(b));
        LayoutHelper gbcPenerima = new LayoutHelper();

        JPanel row1 = new JPanel(new GridBagLayout());
        // row1.setBackground(Color.ORANGE);
        LayoutHelper gbcrow1 = new LayoutHelper();
        row1.setBackground(new Color(a));

        JPanel rowrow = new JPanel(new GridBagLayout());
        rowrow.setSize(new Dimension(500, 300));
        LayoutHelper gbcrowrow = new LayoutHelper();
        rowrow.setOpaque(false);

        JPanel row2 = new JPanel(new GridBagLayout());
        LayoutHelper gbcrow2 = new LayoutHelper();
        row2.setBackground(new Color(a));

        ImageIcon profil = new ImageIcon(TabHandler.class.getResource("/TA.Foto/Profile200.png"));

        JLabel Labrow1 = new JLabel();
        JLabel Labrow2 = new JLabel();
        JLabel LabFoto = new JLabel(profil);
        JLabel LabNama = new JLabel("Nama: ");
        JLabel LabNotlp = new JLabel("Nomor Telepon: ");
        JLabel LabAlamat = new JLabel("Alamat: ");
        JLabel LabEkspedisi = new JLabel("Ekspedisi: ");

        Labrow1.setPreferredSize(new Dimension(500, 70));
        Labrow1.setFont(new Font("Tahoma", Font.BOLD, 30));
        Labrow1.setHorizontalAlignment(SwingConstants.CENTER);
        Labrow1.setText("Data Diri Penerima");
        Labrow2.setPreferredSize(new Dimension(500, 70));
        Labrow2.setFont(new Font("Tahoma", Font.BOLD, 30));
        Labrow2.setHorizontalAlignment(SwingConstants.CENTER);
        Labrow2.setText("Data Songket");
        LabFoto.setPreferredSize(new Dimension(150, 170));
        LabNama.setPreferredSize(new Dimension(95, 30));
        LabNotlp.setPreferredSize(new Dimension(95, 30));
        LabAlamat.setPreferredSize(new Dimension(95, 30));
        LabEkspedisi.setPreferredSize(new Dimension(95, 30));

        JLabel LabSongket = new JLabel("Jenis Songket");
        LabSongket.setPreferredSize(new Dimension(100, 30));

        JLabel LabWarna = new JLabel("Warna");
        LabWarna.setPreferredSize(new Dimension(100, 30));

        JLabel LabUkuran = new JLabel("Ukuran");
        LabUkuran.setPreferredSize(new Dimension(100, 30));

        JLabel LabJumlah = new JLabel("Jumlah");
        LabJumlah.setPreferredSize(new Dimension(100, 30));

        JLabel LabBahan = new JLabel("Bahan");
        LabBahan.setPreferredSize(new Dimension(100, 30));

        songketCombo.setPreferredSize(new Dimension(150, 30));

        warnaCombo.setPreferredSize(new Dimension(150, 30));

        bahanCombo.setPreferredSize(new Dimension(150, 30));

        spinnerJumlah.setPreferredSize(new Dimension(150, 30));

        gbcrow1.setInsets(5, 0, 0, 0);
        gbcrow1.setAnchor(GridBagConstraints.CENTER);
        gbcrow1.setWeightx(1.0);
        gbcrow1.setWeighty(0.5);
        gbcrow1.setGridHeight(1);
        gbcrow1.addComponent(row1, Labrow1, 0, 0, 3);
        gbcrow1.setWeightx(1.0);
        gbcrow1.setWeighty(0.3);
        gbcrow1.setGridHeight(3);
        // gbcrow1.setAnchor(GridBagConstraints.WEST);
        gbcrow1.setInsets(5, 20, 10, 20);
        gbcrow1.addComponent(row1, LabFoto,0,1,1);
        // gbcrow1.setWeightx(0.5);
        // gbcrow1.setWeighty(0.1); 
        gbcrow1.setGridHeight(1);
        gbcrow1.setInsets(5, 0, 10, 0);
        gbcrow1.addComponent(row1, rowrow,1,1, 2);

        // gbcrowrow.setFill(GridBagConstraints.WEST);
        gbcrowrow.setInsets(5,0,5,0);
        gbcrowrow.addComponent(rowrow, LabNama,0,1 );
        gbcrowrow.addComponent(rowrow, TFNama,1,1, 3 );
        gbcrowrow.addComponent(rowrow, LabNotlp,0,2 );
        gbcrowrow.addComponent(rowrow, TFNotlp,1,2, 3 );
        gbcrowrow.addComponent(rowrow, LabAlamat, 0, 3);
        gbcrowrow.addComponent(rowrow, TFAlamat, 1, 3, 3);

        gbcrow2.setInsets(0, 100, 0, 100);
        gbcrow2.setAnchor(GridBagConstraints.CENTER);
        gbcrow2.setWeightx(1.0);
        gbcrow2.setWeighty(0.5);
        gbcrow2.setGridHeight(1);
        gbcrow2.addComponent(row2, Labrow2, 0, 0, 3);
        gbcrow2.setWeightx(0.5);
        gbcrow2.setWeighty(0.1); 
        gbcrow2.setGridHeight(1);
        gbcrow2.addComponent(row2, LabEkspedisi, 0, 1, 1 );
        gbcrow2.addComponent(row2, ekspedisiCombo, 0, 2);
        gbcrow2.addComponent(row2, LabSongket, 1, 1);
        gbcrow2.addComponent(row2, songketCombo, 1, 2);
        gbcrow2.addComponent(row2, LabWarna, 0, 3);
        gbcrow2.addComponent(row2, warnaCombo, 0, 4);
        gbcrow2.addComponent(row2, LabBahan, 1, 3);
        gbcrow2.addComponent(row2, bahanCombo, 1, 4);
        gbcrow2.setInsets(0, 100, 10, 100);
        gbcrow2.addComponent(row2, LabJumlah, 0, 5);
        gbcrow2.addComponent(row2, spinnerJumlah, 0, 6);

        gbcPenerima.setInsets(5, 10,10, 10);
        gbcPenerima.setFill(GridBagConstraints.BOTH );
        gbcPenerima.addComponent(panelPenerima, row1, 0, 0);
        gbcPenerima.setInsets(10, 10,5, 10);
        gbcPenerima.addComponent(panelPenerima, row2, 0, 1);

        JPanel panelStok = new JPanel();
        panelStok.setBackground(new Color(b));
        panelStok.setLayout(new GridBagLayout());
        panelStok.setVisible(false);

        JTable tabelStok = new JTable(modelStok);
        JScrollPane tabelStokScroll = new JScrollPane(tabelStok);
        panelStok.add(tabelStokScroll);

        //-----------------------------------------------------------------------------------------
        JPanel hiddenPanelContainer = new JPanel();
        hiddenPanelContainer.setLayout(new BoxLayout(hiddenPanelContainer, BoxLayout.Y_AXIS));
        hiddenPanelContainer.add(panelPenerima);
        hiddenPanelContainer.add(panelStok);

        tab.add(hiddenPanelContainer, BorderLayout.CENTER);

        //-----------------------------------------------------------------------------------------
        JPanel PesananSaatIni = new JPanel();
        PesananSaatIni.setBackground(new Color(b));
        PesananSaatIni.setLayout(new GridBagLayout());

        LayoutHelper gbcPSI = new LayoutHelper();

        JTable tablePesanan = new JTable(tabelPesananSaatIni);

        JScrollPane scrollPesananSaatIni = new JScrollPane(tablePesanan);
        tablePesanan.setOpaque(false);
        tablePesanan.setBackground(new Color(0,0,0, 60));

        karyawanCombo.setPreferredSize(new Dimension(150, 30));

        gbcPSI.setInsets(5, 0, 5, 30);
        gbcPSI.addComponent(PesananSaatIni, scrollPesananSaatIni, 0, 0);
        gbcPSI.addComponent(PesananSaatIni, karyawanCombo, 0, 1);

        RoundedPanel panelTombol = new RoundedPanel(30);
        panelTombol.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelTombol.setBackground(new Color(a));
        LayoutHelper gbcPTombol = new LayoutHelper(); 

        gbcPTombol.addComponent(panelTombol, butSimpan, 0, 1);
        gbcPTombol.addComponent(panelTombol, butUpload, 1, 1);
        gbcPTombol.addComponent(panelTombol, butTamb, 2, 1);
        gbcPTombol.addComponent(panelTombol, butSimUp, 3, 1);

        gbcPSI.addComponent(PesananSaatIni, panelTombol, 0, 2);

        
        //-----------------------------------------------------------------------------------------
        JPanel panelPesanan = new JPanel();
        panelPesanan.setVisible(false);
        panelPesanan.setLayout(new GridBagLayout());
        panelPesanan.setBackground(new Color(b));

        JPanel panelButtonPesanan = new JPanel();
        panelButtonPesanan.setLayout(new FlowLayout(FlowLayout.CENTER,5 ,5));
        panelButtonPesanan.setPreferredSize(new Dimension(105, 105));
        panelButtonPesanan.setBackground(new Color(c));


        LayoutHelper gbcPesanan = new LayoutHelper();

        tabelPesananNoID.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                handleTableClick(e, tabelPesananNoID);
            }
        });

        JScrollPane scrollPesanan = new JScrollPane(tabelPesananNoID);
        tabelPesananNoID.setOpaque(false);
        tabelPesananNoID.setBackground(new Color(0,0,0, 60));

        panelButtonPesanan.add(butUbahPesanan);
        panelButtonPesanan.add(butHapusPesanan);
        panelButtonPesanan.add(butHapusSemua);
        panelButtonPesanan.add(butBatalPesanan);

        gbcPesanan.setInsets(5, 0, 5, 30);
        gbcPesanan.addComponent(panelPesanan, scrollPesanan, 0, 0);
        gbcPesanan.addComponent(panelPesanan, panelButtonPesanan, 0, 1);

        JPanel panelKananContainer = new JPanel();
        panelKananContainer.setLayout(new BoxLayout(panelKananContainer, BoxLayout.Y_AXIS));
        panelKananContainer.add(panelPesanan);
        panelKananContainer.add(PesananSaatIni);


        tab.add(panelKananContainer, BorderLayout.EAST);
        
                //-----------------------------------------------------------------------------------------
        RoundedPanel buttonPanel = new RoundedPanel(60);
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setBackground(new Color(c));

        JButton butStok = new JButton("Tabel Songket");
        butStok.addActionListener(e -> {
            toggleVisibility(tab, panelStok, panelPenerima);
        });

        JButton butUbah = new JButton("Ubah Order");
        butUbah.addActionListener(e -> {
            toggleVisibility(tab, panelPesanan, PesananSaatIni);
        });

        // butAkun.addActionListener(e -> {
            
        // });

        buttonPanel.add(butStok, BorderLayout.WEST);
        buttonPanel.add(butRefresh, BorderLayout.CENTER);
        buttonPanel.add(butAkun, BorderLayout.AFTER_LAST_LINE);
        buttonPanel.add(butUbah, BorderLayout.EAST);

        tab.add(buttonPanel, BorderLayout.NORTH);
        return tab;
    }

    private JPanel createTab2() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();

        jPanel1.setBackground(new Color(b));
        jPanel2.setBackground(new Color(b));
        panel.setBackground(new Color(b));
        // Create components for jPanel1
        // JTextField TF = new JTextField();
        // JButton btnUbah = new JButton("Ubah");
        // JButton btnHapus = new JButton("Hapus");
        // JButton btnTambah = new JButton("Tambah");
        // JComboBox<String> Combo = new JComboBox<>();
        
        // Set up action listeners for buttons

        btnUbah.addActionListener(e -> {
            String pilih = (String) Combo.getSelectedItem();
            updateIsi(pilih);
        });

        btnHapus.addActionListener(e -> {
            String pilih = (String) Combo.getSelectedItem();
            Hapus(pilih);
        });

        btnTambah.addActionListener(e -> {
            String pilih = (String) Combo.getSelectedItem();
            tambah(pilih);
        });
        
        // btnHapus.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent evt) {
        //         // Handle Hapus button action
        //     }
        // });
        
        // btnTambah.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent evt) {
        //         // Handle Tambah button action
        //     }
        // });
        
        // Combo.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent evt) {
        //         // Handle Combo action
        //     }
        // });

        // Set layout and add components to jPanel1
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUbah)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambah))
                    .addComponent(TF))
                .addGap(24, 24, 24)
                .addComponent(Combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(TF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnTambah))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Create tables and scroll panes for jPanel2
        JScrollPane scrollSongket = new JScrollPane();
        scrollSongket.setViewportView(tabelSongket);

        JScrollPane scrollWarna = new JScrollPane();
        scrollWarna.setViewportView(tabelWarna);

        JScrollPane scrollBahan = new JScrollPane();
        scrollBahan.setViewportView(tabelBahan);

        JScrollPane scrollEkspedisi = new JScrollPane();
        scrollEkspedisi.setViewportView(tabelEkspedisi);

        // Set layout and add components to jPanel2
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollSongket, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBahan, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollWarna, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollEkspedisi, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scrollBahan, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(scrollWarna, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(scrollEkspedisi, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(scrollSongket, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(124, 124, 124))
        );


        tabelBahan.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                String rah = (String) Combo.getSelectedItem();
                handleTableClick(rah);
            }
        });

        tabelEkspedisi.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent er) {
                String rah = (String) Combo.getSelectedItem();
                handleTableClick(rah);
            }
        });

        tabelSongket.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent es) {
                String rah = (String) Combo.getSelectedItem();
                handleTableClick(rah);
            }
        });

        tabelWarna.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent et) {
                String rah = (String) Combo.getSelectedItem();
                handleTableClick(rah);
            }
        });

        panel.add(jPanel1, BorderLayout.WEST);
        panel.add(jPanel2, BorderLayout.EAST);
        return panel;
    }

    private JPanel createTab3() {
        JPanel panel = new JPanel(new BorderLayout());
        // Tambahkan komponen ke tab3
        return panel;
    }

    public String getTFNama() {
        return TFNama.getText();
    }
    
    public String getTFNotlp() {
        return TFNotlp.getText();
    }
    
    public String getTFAlamat() {
        return TFAlamat.getText();
    }
    
    public Data getEkspedisiComboValue() {
        return (Data) ekspedisiCombo.getSelectedItem();
    }

    public Data getSongketComboValue() {
        return (Data) songketCombo.getSelectedItem();
    }
    
    public Data getWarnaComboValue() {
        return (Data) warnaCombo.getSelectedItem();
    }
    
    public Data getBahanComboValue() {
        return (Data) bahanCombo.getSelectedItem();
    }
    
    public Data getKaryawanComboValue() {
        return (Data) karyawanCombo.getSelectedItem();
    }
    
    public int getSpinnerJumlahValue() {
        return (int) spinnerJumlah.getValue();
    }

    public int getIDpesanan(){
        return idPesanan;
    }

    public int getIDdetailPesanan(){
        return idDetailPesanan;
    }

    public void setTabelPesananSaatIni(String nama, String songket, String warna, String bahan, int jumlah) {
        this.tabelPesananSaatIni.addRow(new Object[]{nama, songket, warna, bahan, jumlah});
    }

    public void setTabelModelDetailPesanan(DefaultTableModel tabelModelDetailPesanan) {
        this.tabelModelDetailPesanan = tabelModelDetailPesanan;
        this.tabelModelDetailPesanan.fireTableDataChanged();
    }

    public void setTabelModelPesanan(DefaultTableModel tabelModelPesanan) {
        this.tabelModelPesanan = tabelModelPesanan;
        this.tabelModelPesanan.fireTableDataChanged();
    }

    public DefaultTableModel getTabelPesananSaatIni() {
        return tabelPesananSaatIni;
    }

    public DefaultTableModel getTabelModelDetailPesanan() {
        return tabelModelDetailPesanan;
    }

    public DefaultTableModel getTabelModelPesanan() {
        return tabelModelPesanan;
    }

    public void kosongkan(){
        TFNama.setText("");
        TFNotlp.setText("");
        TFAlamat.setText("");
        ekspedisiCombo.setSelectedIndex(0);
        songketCombo.setSelectedIndex(0);
        warnaCombo.setSelectedIndex(0);
        bahanCombo.setSelectedIndex(0);
        karyawanCombo.setSelectedIndex(0);
        TF.setText("t");
        tabelSongket.clearSelection();
        tabelBahan.clearSelection();
        tabelEkspedisi.clearSelection();
        tabelWarna.clearSelection();
    }

    public void kosongkantabel(){
        tabelPesananSaatIni.setRowCount(0);
    }

    public void restart(){
        modelStok.setRowCount(0);
        tabelModelPesanan.setRowCount(0);
        ekspedisiCombo.removeAllItems();
        songketCombo.removeAllItems();
        warnaCombo.removeAllItems();
        bahanCombo.removeAllItems();
        karyawanCombo.removeAllItems();
        this.idCounterKaryawan = 100001;
        this.idCounterSongket = 200001;
        this.idCounterBahan = 300001;
        this.idCounterWarna = 400001;
        this.idCounterEkspedisi = 500001;
        loadData();

        modelBahan.setRowCount(0);
        modelEkspedisi.setRowCount(0);
        modelSongket.setRowCount(0);
        modelWarna.setRowCount(0);
        Combo.removeAllItems();
        data();
    }

    public boolean validasiInput() {
        if (TFNama.getText().trim().isEmpty() || TFNotlp.getText().trim().isEmpty() || TFAlamat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tidak boleh ada field kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean validasiTabel() {
        if (tabelPesananSaatIni.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Tabel Pesanan masih kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    

    public void simpanKeTabel (ActionListener listener){
        butSimpan.addActionListener(listener);
    }

    public void simpuad (ActionListener listener){
        butSimUp.addActionListener(listener);
    }

    public void uploadKeDatabase (ActionListener listener){
        butUpload.addActionListener(listener);
    }

    public void tambahKeTabel (ActionListener listener){
        butTamb.addActionListener(listener);
    }

    public void ubahdata (ActionListener listener){
        butUbahPesanan.addActionListener(listener);
    }

    public void Hapus (ActionListener listener){
        butHapusPesanan.addActionListener(listener);
    }

    public void HapusSemua (ActionListener listener){
        butHapusSemua.addActionListener(listener);
    }

    public void Akun (ActionListener listener){
        butAkun.addActionListener(listener);
    }

    public void Refresh (ActionListener listener){
        butRefresh.addActionListener(listener);
    }
}
