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
    JButton butUbahPesanan;
    JButton butHapusPesanan;
    JButton butBatalPesanan;
    JButton butHapusSemua;
    

    public TabHandler(){
        String[] headerStok = {"Songket", "Harga", "Stok"};
        this.modelStok = new DefaultTableModel(headerStok, 0); // Inisialisasi model
        this.TFNama = new JTextField(15);
        this.TFNotlp = new JTextField(15);
        this.TFAlamat = new JTextField(15);
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
                // Mengembalikan false untuk mencegah sel bisa diedit
                return false;
            }
        };
        this.tabelModelDetailPesanan = new DefaultTableModel(headerDetailPesanan, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Mengembalikan false untuk mencegah sel bisa diedit
                return false;
            }
        };
        this.tabelModelPesanan = new DefaultTableModel(headerPesanan, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Mengembalikan false untuk mencegah sel bisa diedit
                return false;
            }
        };
        this.tabelPesanan = new JTable(tabelModelPesanan);
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

        loadData();

        JPanel tab1 = createTab1();
        JPanel tab2 = createTab2();
        JPanel tab3 = createTab3();

        tabbedPane.addTab("Buat Order", tab1);
        tabbedPane.addTab("Ubah Order", tab2);
        tabbedPane.addTab("e-commerce", tab3);

        return tabbedPane;
    }

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
        JPanel panelPenerima = new JPanel(new GridBagLayout());
        panelPenerima.setBackground(Color.YELLOW);
        LayoutHelper gbcPenerima = new LayoutHelper();

        JPanel row1 = new JPanel(new GridBagLayout());
        LayoutHelper gbcrow1 = new LayoutHelper();
        row1.setOpaque(false);

        JPanel rowrow = new JPanel(new GridBagLayout());
        rowrow.setPreferredSize(new Dimension(500, 200));
        LayoutHelper gbcrowrow = new LayoutHelper();
        rowrow.setOpaque(false);

        JPanel row2 = new JPanel(new GridBagLayout());
        LayoutHelper gbcrow2 = new LayoutHelper();
        row2.setOpaque(false);

        ImageIcon profil = new ImageIcon(TabHandler.class.getResource("/TA.Foto/Profile200.png"));

        JLabel Labrow1 = new JLabel();
        JLabel LabFoto = new JLabel(profil);
        JLabel LabNama = new JLabel("Nama: ");
        JLabel LabNotlp = new JLabel("Nomor Telepon: ");
        JLabel LabAlamat = new JLabel("Alamat: ");
        JLabel LabEkspedisi = new JLabel("Ekspedisi: ");

        Labrow1.setPreferredSize(new Dimension(500, 70));
        Labrow1.setFont(new Font("Tahoma", Font.BOLD, 30));
        Labrow1.setHorizontalAlignment(SwingConstants.CENTER);
        Labrow1.setText("Data Diri Penerima");
        LabFoto.setPreferredSize(new Dimension(200, 200));
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

        gbcrow1.setAnchor(GridBagConstraints.CENTER);
        gbcrow1.setWeightx(1.0);
        gbcrow1.setWeighty(0.5);
        gbcrow1.setGridHeight(1);
        gbcrow1.addComponent(row1, Labrow1, 0, 0, 3);
        gbcrow1.setWeightx(1.0);
        gbcrow1.setWeighty(0.3);
        gbcrow1.setGridHeight(3);
        gbcrow1.addComponent(row1, LabFoto,0,1,1);
        gbcrow1.setWeightx(0.5);
        gbcrow1.setWeighty(0.1); 
        gbcrow1.setGridHeight(1);
        gbcrow1.addComponent(row1, rowrow,1,1 );

        gbcrowrow.setFill(GridBagConstraints.BOTH);
        gbcrowrow.setInsets(5,0,5,0);
        gbcrowrow.addComponent(rowrow, LabNama,0,1 );
        gbcrowrow.addComponent(rowrow, TFNama,1,1, 2 );
        gbcrowrow.addComponent(rowrow, LabNotlp,0,2 );
        gbcrowrow.addComponent(rowrow, TFNotlp,1,2, 2 );
        gbcrowrow.addComponent(rowrow, LabAlamat, 0, 3);
        gbcrowrow.addComponent(rowrow, TFAlamat, 1, 3, 2);

        gbcrow2.setInsets(5, 100, 0, 100);
        gbcrow2.addComponent(row2, LabEkspedisi, 0, 0 );
        gbcrow2.addComponent(row2, ekspedisiCombo, 0, 1);
        gbcrow2.addComponent(row2, LabSongket, 1, 0);
        gbcrow2.addComponent(row2, songketCombo, 1, 1);
        gbcrow2.addComponent(row2, LabWarna, 0, 2);
        gbcrow2.addComponent(row2, warnaCombo, 0, 3);
        gbcrow2.addComponent(row2, LabBahan, 1, 2);
        gbcrow2.addComponent(row2, bahanCombo, 1, 3);
        gbcrow2.addComponent(row2, LabJumlah, 0, 4);
        gbcrow2.addComponent(row2, spinnerJumlah, 0, 5);

        gbcPenerima.setInsets(5, 10,20, 10);
        gbcPenerima.setFill(GridBagConstraints.BOTH );
        gbcPenerima.addComponent(panelPenerima, row1, 0, 0);
        gbcPenerima.setInsets(20, 10,5, 10);
        gbcPenerima.addComponent(panelPenerima, row2, 0, 1);

        JPanel panelStok = new JPanel();
        panelStok.setBackground(Color.MAGENTA);
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
        PesananSaatIni.setLayout(new GridBagLayout());

        LayoutHelper gbcPSI = new LayoutHelper();

        JTable tablePesanan = new JTable(tabelPesananSaatIni);

        JScrollPane scrollPesananSaatIni = new JScrollPane(tablePesanan);

        karyawanCombo.setPreferredSize(new Dimension(150, 30));

        gbcPSI.addComponent(PesananSaatIni, scrollPesananSaatIni, 0, 0);
        gbcPSI.addComponent(PesananSaatIni, karyawanCombo, 0, 1);

        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER));
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

        JPanel panelButtonPesanan = new JPanel();
        panelButtonPesanan.setLayout(new FlowLayout(FlowLayout.CENTER,5 ,5));
        panelButtonPesanan.setPreferredSize(new Dimension(105, 105));


        LayoutHelper gbcPesanan = new LayoutHelper();


        tabelPesanan.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                handleTableClick(e, tabelPesanan);
            }
        });

        JScrollPane scrollPesanan = new JScrollPane(tabelPesanan);

        panelButtonPesanan.add(butUbahPesanan);
        panelButtonPesanan.add(butHapusPesanan);
        panelButtonPesanan.add(butHapusSemua);
        panelButtonPesanan.add(butBatalPesanan);

        gbcPesanan.addComponent(panelPesanan, scrollPesanan, 0, 0);
        gbcPesanan.addComponent(panelPesanan, panelButtonPesanan, 0, 1);

        JPanel panelKananContainer = new JPanel();
        panelKananContainer.setLayout(new BoxLayout(panelKananContainer, BoxLayout.Y_AXIS));
        panelKananContainer.add(panelPesanan);
        panelKananContainer.add(PesananSaatIni);


        tab.add(panelKananContainer, BorderLayout.EAST);
        
                //-----------------------------------------------------------------------------------------
        JPanel buttonPanel = new JPanel(new BorderLayout());
        // buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton butStok = new JButton("Tabel Songket");
        butStok.addActionListener(e -> {
            toggleVisibility(tab, panelStok, panelPenerima);
        });

        JButton butUbah = new JButton("Ubah Order");
        butUbah.addActionListener(e -> {
            toggleVisibility(tab, panelPesanan, PesananSaatIni);
        });

        buttonPanel.add(butStok, BorderLayout.WEST);
        buttonPanel.add(butUbah, BorderLayout.EAST);

        tab.add(buttonPanel, BorderLayout.NORTH);
        return tab;
    }

    private JPanel createTab2() {
        JPanel panel = new JPanel(new BorderLayout());
    
        // Panel utama dengan GridLayout untuk form
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        // Komponen input
        JTextField usernameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField phoneField = new JTextField();
    
        // Tambahkan label dan field ke formPanel
        formPanel.add(new JLabel("Username:"));
        formPanel.add(usernameField);
    
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
    
        formPanel.add(new JLabel("Nama Pengguna:"));
        formPanel.add(nameField);
    
        formPanel.add(new JLabel("Nomor Telepon:"));
        formPanel.add(phoneField);
    
        // Tombol untuk ganti password dan email
        JButton changePasswordButton = new JButton("Ganti Password");
        JButton changeEmailButton = new JButton("Ganti Email");
    
        // Tambahkan tombol ke formPanel
        formPanel.add(changePasswordButton);
        formPanel.add(changeEmailButton);
    
        // Tambahkan action listener untuk tombol
        changePasswordButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "Ganti Password clicked!");
        });
    
        changeEmailButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "Ganti Email clicked!");
        });
    
        // Tambahkan formPanel ke panel utama
        panel.add(formPanel, BorderLayout.CENTER);
    
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
    }

    public boolean validasiInput() {
        // Validasi input lain, misalnya JTextField kosong
        if (TFNama.getText().trim().isEmpty() || TFNotlp.getText().trim().isEmpty() || TFAlamat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tidak boleh ada field kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean validasiTabel() {
        // Validasi tabel kosong
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
}
