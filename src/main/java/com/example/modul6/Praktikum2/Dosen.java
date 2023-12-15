package com.example.modul6.Praktikum2;



import javafx.beans.property.SimpleStringProperty;

public class Dosen {
    private final SimpleStringProperty nama;
    private final SimpleStringProperty GKB;

    private final SimpleStringProperty waktu;
    private final SimpleStringProperty mataKuliah;

    private final SimpleStringProperty ruangan;



    public Dosen(String nama, String GKB, String waktu, String ruangan, String mataKuliah) {
        this.nama = new SimpleStringProperty(nama);
        this.GKB = new SimpleStringProperty(GKB);
        this.waktu = new SimpleStringProperty(waktu);
        this.ruangan = new SimpleStringProperty(ruangan);
        this.mataKuliah = new SimpleStringProperty(mataKuliah);
    }

    public String getMataKuliah() {
        return mataKuliah.get();
    }

    public SimpleStringProperty mataKuliahProperty() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah.set(mataKuliah);
    }

    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public String getGKB() {
        return GKB.get();
    }


    public void setGKB(String GKB) {
        this.GKB.set(GKB);
    }

    public String getWaktu() {
        return waktu.get();
    }


    public void setWaktu(String waktu) {
        this.waktu.set(waktu);
    }

    public String getRuangan() {
        return ruangan.get();
    }

    public SimpleStringProperty ruanganProperty() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan.set(ruangan);
    }
}

