package TA;

import java.awt.event.ActionEvent;

public class DataController {
    private final TabHandler GUI;
    private final UbahPassworddanUsername PASS;

    public DataController(TabHandler gui, DataHandler hand, UbahPassworddanUsername pass, Login login){
        this.GUI = gui;
        this.PASS = pass;

        this.GUI.simpanKeTabel((ActionEvent e) -> {
            if (!gui.validasiInput()) {
                return; // Berhenti jika validasi gagal
            }
            hand.setNama(gui.getTFNama());
            hand.setAlamat(gui.getTFAlamat());
            hand.setNoTelepon(gui.getTFNotlp());
            hand.setSongket(gui.getSongketComboValue());
            hand.setWarna(gui.getWarnaComboValue());
            hand.setBahan(gui.getBahanComboValue());
            hand.setJumlah(gui.getSpinnerJumlahValue());
            hand.setIDKaryawan(gui.getKaryawanComboValue());
            hand.setIDSongket(gui.getSongketComboValue());
            hand.setIDBahan(gui.getBahanComboValue());
            hand.setIDWarna(gui.getWarnaComboValue());
            hand.setIDEkspedisi(gui.getEkspedisiComboValue());
            hand.simpanDatakeTable();
            gui.setTabelPesananSaatIni(hand.getWarna(), hand.getSongket(), hand.getWarna(), hand.getBahan(), hand.getJumlah());
            gui.kosongkan();
        });

        this.GUI.tambahKeTabel((ActionEvent e) -> {
            if (!gui.validasiInput()) {
                return; // Berhenti jika validasi gagal
            }
            hand.setSongket(gui.getSongketComboValue());
            hand.setWarna(gui.getWarnaComboValue());
            hand.setBahan(gui.getBahanComboValue());
            hand.setJumlah(gui.getSpinnerJumlahValue());
            hand.setIDSongket(gui.getSongketComboValue());
            hand.setIDBahan(gui.getBahanComboValue());
            hand.setIDWarna(gui.getWarnaComboValue());
            hand.setIDEkspedisi(gui.getEkspedisiComboValue());
            hand.simpanDatakeTable();
            gui.setTabelPesananSaatIni(hand.getWarna(), hand.getSongket(), hand.getWarna(), hand.getBahan(), hand.getJumlah());
        });

        this.GUI.uploadKeDatabase((ActionEvent e) -> {
            if (!gui.validasiTabel()) {
                return; // Berhenti jika validasi gagal
            }
            hand.simpanPesananDariTabelKeTabelPesanan();
            gui.kosongkantabel();
            gui.kosongkan();
            gui.restart();
        });

        this.GUI.simpuad((ActionEvent e) -> {
            if (!gui.validasiInput()) {
                return; // Berhenti jika validasi gagal
            }
            hand.setNama(gui.getTFNama());
            hand.setAlamat(gui.getTFAlamat());
            hand.setNoTelepon(gui.getTFNotlp());
            hand.setSongket(gui.getSongketComboValue());
            hand.setWarna(gui.getWarnaComboValue());
            hand.setBahan(gui.getBahanComboValue());
            hand.setJumlah(gui.getSpinnerJumlahValue());
            hand.setIDKaryawan(gui.getKaryawanComboValue());
            hand.setIDSongket(gui.getSongketComboValue());
            hand.setIDBahan(gui.getBahanComboValue());
            hand.setIDWarna(gui.getWarnaComboValue());
            hand.setIDEkspedisi(gui.getEkspedisiComboValue());
            hand.simpanDatakeTable();
            gui.setTabelPesananSaatIni(hand.getWarna(), hand.getSongket(), hand.getWarna(), hand.getBahan(), hand.getJumlah());
            if (!gui.validasiTabel()) {
                return; // Berhenti jika validasi gagal
            }
            hand.simpanPesananDariTabelKeTabelPesanan();
            gui.kosongkantabel();
            gui.kosongkan();
            gui.restart();
        });

        this.GUI.ubahdata((ActionEvent e) -> {
            if (!gui.validasiInput()) {
                return; // Berhenti jika validasi gagal
            }
            hand.setIDdetailpesanan(gui.getIDdetailPesanan());
            hand.setIDpesanan(gui.getIDpesanan());
            hand.setNama(gui.getTFNama());
            hand.setAlamat(gui.getTFAlamat());
            hand.setNoTelepon(gui.getTFNotlp());
            hand.setSongket(gui.getSongketComboValue());
            hand.setWarna(gui.getWarnaComboValue());
            hand.setBahan(gui.getBahanComboValue());
            hand.setJumlah(gui.getSpinnerJumlahValue());
            hand.setIDKaryawan(gui.getKaryawanComboValue());
            hand.setIDSongket(gui.getSongketComboValue());
            hand.setIDBahan(gui.getBahanComboValue());
            hand.setIDWarna(gui.getWarnaComboValue());
            hand.setIDEkspedisi(gui.getEkspedisiComboValue());
            hand.updatePesananInDatabase();
            hand.updateDetailPesananInDatabase();
            gui.restart();
        });

        this.GUI.Hapus((ActionEvent e) -> {
            hand.setIDdetailpesanan(gui.getIDdetailPesanan());
            hand.setIDSongket(gui.getSongketComboValue());
            hand.setIDBahan(gui.getBahanComboValue());
            hand.setIDWarna(gui.getWarnaComboValue());
            hand.deleteDetailPesananFromDatabase();
            gui.restart();
        });

        this.GUI.HapusSemua((ActionEvent e) -> {
            hand.setIDpesanan(gui.getIDpesanan());
            hand.deletePesananFromDatabase();
            gui.restart();
        });

        this.GUI.Akun((ActionEvent e) -> {
            System.out.println("Akun Diklik");
            hand.setIDLogin(login.getIDLogin());
            pass.setUserID(hand.getIDLogin());
            System.out.println(login.getIDLogin());
            pass.setVisible(true);
        });

        this.GUI.Refresh((ActionEvent e) -> {
            System.out.println("Refresh Diklik");
            gui.restart();
        });
    }
}
