package TA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class DataHandler {
    private Connection connection;
    private String nama;
    private String noTelepon;
    private String alamat;
    private String songket;
    private String warna;
    private String bahan;
    private int IDekspedisi;
    private int IDsongket;
    private int IDwarna;
    private int IDbahan;
    private int IDkaryawan;
    private int IDpesanan;
    private int idDetailPesanan;
    private int jumlah;
    private DefaultTableModel tabelPesananSaatIni;
    private DefaultTableModel tabelModelDetailPesanan;
    private DefaultTableModel tabelModelPesanan;

    public DataHandler(){
        String[] headerDetailPesanan = {"Jenis Songket", "Bahan", "Warna", "Jumlah", "jumah"};
        String[] headerPesanan = {"Penerima", "No. Telepon", "Alamat", "Ekspedisi", "Songket"};
        this.tabelPesananSaatIni = new DefaultTableModel();
        this.tabelModelDetailPesanan = new DefaultTableModel(headerDetailPesanan, 0);
        this.tabelModelPesanan = new DefaultTableModel(headerPesanan, 0);
        try {
            // Memanggil koneksi hanya sekali ketika objek Utama dibuat
            this.connection = DatabaseConnection.getConnection();
            System.out.println("Koneksi berhasil!");
        } catch (SQLException e) {
            System.err.println("Gagal terhubung ke database: " + e.getMessage());
        }
    }

    public int getIDpesanan(){
        return IDpesanan;
    }

    public void setIDpesanan(int pesanan){
        this.IDpesanan = pesanan;
    }

    public int getIDdetailPesanan(){
        return idDetailPesanan;
    }

    public void setIDdetailpesanan(int idDetailPesanan){
        this.idDetailPesanan = idDetailPesanan;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getJumlah(){
        return jumlah;
    }

    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }

    public void setSongket(Data songket) {
        this.songket = songket.getLabel();
    }

    public String getSongket(){
        return songket;
    }
    
    public String getWarna() {
        return warna;
    }
    
    public void setWarna(Data warna) {
        this.warna = warna.getLabel();
    }
    
    public String getBahan() {
        return bahan;
    }
    
    public void setBahan(Data bahan) {
        this.bahan = bahan.getLabel();
    }

    public int getIDEkspedisi() {
        return IDekspedisi;
    }

    public void setIDEkspedisi(Data ekspedisi) {
        this.IDekspedisi = (int) ekspedisi.getId();
    }

    public int getIDSongket() {
        return IDsongket;
    }

    public void setIDSongket(Data songket) {
        this.IDsongket = (int) songket.getId();
    }

    public int getIDWarna() {
        return IDwarna;
    }

    public void setIDWarna(Data warna) {
        this.IDwarna = (int) warna.getId();
    }

    public int getIDBahan() {
        return IDbahan;
    }

    public void setIDBahan(Data bahan) {
        this.IDbahan = (int) bahan.getId();
    }

    public int getIDKaryawan() {
        return IDkaryawan;
    }

    public void setIDKaryawan(Data karyawan) {
        this.IDkaryawan = (int) karyawan.getId();
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

    public void simpanDatakeTable(){
        int kunci = -1;
        tabelModelDetailPesanan.addRow(new Object[]{kunci++, IDsongket, IDbahan, IDwarna, jumlah});
        tabelPesananSaatIni.addRow(new Object[]{nama, songket, warna, bahan, jumlah});
        int warnaID = Integer.parseInt(tabelModelDetailPesanan.getValueAt(0, 3).toString());
        int jumlahid = Integer.parseInt(tabelModelDetailPesanan.getValueAt(0, 4).toString());

        System.out.println("hasil" + nama+songket+warna+bahan+jumlahid);
        System.out.println("hasil" + kunci++ +""+IDsongket+""+IDbahan+""+warnaID+""+jumlahid);
    }

    public void simpanPesananDariTabelKeTabelPesanan() {
        int kunci = -1;
        tabelModelPesanan.addRow(new Object[]{IDkaryawan, IDekspedisi, nama, noTelepon, alamat});
        int banyak = tabelModelPesanan.getRowCount();
        System.out.println("isi tabel pesanan   " + banyak);
        String ttelepon = tabelModelPesanan.getValueAt(0, 3).toString();
        System.out.println("telepon "+ttelepon);
        String query = "INSERT INTO pesanan (karyawan_id, ekspedisi_id, penerima, telepon, alamat) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
    
            for(int row = 0; row < banyak; row++){
                int karyawanId = Integer.parseInt(tabelModelPesanan.getValueAt(row, 0).toString());
                int ekspedisiId = Integer.parseInt(tabelModelPesanan.getValueAt(row, 1).toString());
                String penerima = tabelModelPesanan.getValueAt(row, 2).toString();
                String telepon = tabelModelPesanan.getValueAt(row, 3).toString();
                String TAlamat = tabelModelPesanan.getValueAt(row, 4).toString();
        
                ps.setInt(1, karyawanId);
                ps.setInt(2, ekspedisiId);
                ps.setString(3, penerima);
                ps.setString(4, telepon);
                ps.setString(5, TAlamat);
                ps.executeUpdate();
            System.out.print("pesanan" + karyawanId + " " + ekspedisiId + " " + penerima + " " + telepon + " " + TAlamat);
            }

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                kunci = rs.getInt(1);    
            System.out.println("Data berhasil dimasukkan ke tabel 'pesanan'. Generated key: " + kunci);
            }
        } catch (SQLException e) {
            System.out.print("Gagal");
        }

        String detailpesananquery = "INSERT INTO detail_pesanan (pesanan_id, songket_id, bahan_id, warna_id, jumlah) VALUES (?, ?, ?, ?, ?)";
            try(PreparedStatement ps2 = connection.prepareStatement(detailpesananquery)){
                int ide = tabelModelDetailPesanan.getRowCount();
                System.out.println("isi tabel detail pesanan  " + ide);
                for (int row = 0; row < tabelModelDetailPesanan.getRowCount(); row++){
                    int songketID = Integer.parseInt(tabelModelDetailPesanan.getValueAt(row, 1).toString());
                    int bahanID = Integer.parseInt(tabelModelDetailPesanan.getValueAt(row, 2).toString());
                    int warnaID = Integer.parseInt(tabelModelDetailPesanan.getValueAt(row, 3).toString());
                    int jumlahdetail = Integer.parseInt(tabelModelDetailPesanan.getValueAt(row, 4).toString());

                    ps2.setInt(1, kunci);
                    ps2.setInt(2, songketID);
                    ps2.setInt(3, bahanID);
                    ps2.setInt(4, warnaID);
                    ps2.setInt(5, jumlahdetail);
                    ps2.executeUpdate();
                System.out.print("Detail Pesanan" + kunci + " " + songketID + " " + bahanID + " " + warnaID + " " + jumlahdetail);
                }

                tabelModelDetailPesanan.setRowCount(0);
                tabelModelPesanan.setRowCount(0);
                tabelPesananSaatIni.setRowCount(0);

            } catch (SQLException ex){
                System.err.println("Gagal masukkan data ke tabel:" + ex.getMessage());
            }
    }

    public void updatePesananInDatabase() {
        // Nilai tetap yang akan digunakan
        String query = "UPDATE pesanan SET karyawan_id = ?, ekspedisi_id = ?, penerima = ?, telepon = ?, alamat = ? WHERE pesanan_id = ?";
    
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Mengisi nilai-nilai ke dalam PreparedStatement
            stmt.setInt(1, IDkaryawan);
            stmt.setInt(2, IDekspedisi);
            stmt.setString(3, nama);
            stmt.setString(4, noTelepon);
            stmt.setString(5, alamat);
            stmt.setInt(6, IDpesanan);
    
            // Menjalankan query dan mendapatkan jumlah baris yang terpengaruh
            int rowsAffected = stmt.executeUpdate();
    
            // Mengecek apakah ada baris yang terpengaruh
            if (rowsAffected > 0) {
                System.out.println("Update berhasil, jumlah baris yang diperbarui: " + rowsAffected);
            } else {
                System.out.println("Tidak ada baris yang diperbarui, pastikan pesanan_id yang dimasukkan benar.");
            }
        } catch (SQLException e) {
            System.err.println("Gagal memperbarui data pesanan: " + e.getMessage());
        }
    }
    
    public void updateDetailPesananInDatabase() {
        // Nilai tetap yang akan digunakan
        int detailpesananId = idDetailPesanan;
        int songketId = IDsongket;
        int bahanId = IDbahan;
        int warnaId = IDwarna;

        String query = "UPDATE detail_pesanan SET songket_id = ?, bahan_id = ?, warna_id = ?, jumlah = ? WHERE detail_pesanan_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Mengisi nilai-nilai ke dalam PreparedStatement
            stmt.setInt(1, songketId);
            stmt.setInt(2, bahanId);
            stmt.setInt(3, warnaId);
            stmt.setInt(4, jumlah);
            stmt.setInt(5, detailpesananId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Gagal memperbarui data detail pesanan: " + e.getMessage());
        }
    }

    public void deleteDetailPesananFromDatabase() {
        if (idDetailPesanan == 0 || IDsongket == 0 || IDbahan == 0 || IDwarna == 0) {
            System.err.println("Nilai ID tidak boleh nol.");
            return;
        }        
        String query = "DELETE FROM detail_pesanan WHERE detail_pesanan_id = ? AND songket_id = ? AND bahan_id = ? AND warna_id = ?";
    
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Mengisi nilai-nilai ke dalam PreparedStatement
            stmt.setInt(1, idDetailPesanan);
            stmt.setInt(2, IDsongket);
            stmt.setInt(3, IDbahan);
            stmt.setInt(4, IDwarna);
    
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Data berhasil dihapus.");
            } else {
                System.out.println("Tidak ada data yang dihapus.");
            }
        } catch (SQLException e) {
            System.err.println("Gagal menghapus data detail pesanan: " + e.getMessage());
        }
    }
    

    public void deletePesananFromDatabase() {
        String query = "DELETE FROM pesanan WHERE pesanan_id = ?";
    
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Mengisi nilai ke dalam PreparedStatement
            stmt.setInt(1, IDpesanan);
    
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Data pesanan berhasil dihapus.");
            } else {
                System.out.println("Tidak ada data pesanan yang dihapus.");
            }
        } catch (SQLException e) {
            System.err.println("Gagal menghapus data pesanan: " + e.getMessage());
        }
    }
    


}
