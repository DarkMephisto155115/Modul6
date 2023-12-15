package com.example.modul6.Praktikum;



import javafx.beans.property.SimpleStringProperty;

public class Mahasiswa {
    private final SimpleStringProperty nama;
    private final SimpleStringProperty NIM;

    private final SimpleStringProperty email;

    private final SimpleStringProperty fakultas;

    private final SimpleStringProperty jurusan;
    private final SimpleStringProperty alamat;
    private final SimpleStringProperty kota;

    public Mahasiswa(String nama, String NIM, String email, String fakultas, String jurusan, String alamat, String kota) {
        this.nama = new SimpleStringProperty(nama);
        this.NIM = new SimpleStringProperty(NIM);
        this.email = new SimpleStringProperty(email);
        this.fakultas = new SimpleStringProperty(fakultas);
        this.jurusan = new SimpleStringProperty(jurusan);
        this.alamat = new SimpleStringProperty(alamat);
        this.kota = new SimpleStringProperty(kota);
    }


    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public String getNIM() {
        return NIM.get();
    }


    public void setNIM(String NIM) {
        this.NIM.set(NIM);
    }

    public String getEmail() {
        return email.get();
    }


    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getFakultas() {
        return fakultas.get();
    }

    public SimpleStringProperty fakultasProperty() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas.set(fakultas);
    }

    public String getJurusan() {
        return jurusan.get();
    }

    public SimpleStringProperty jurusanProperty() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan.set(jurusan);
    }

    public String getAlamat() {
        return alamat.get();
    }

    public SimpleStringProperty alamatProperty() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }

    public String getKota() {
        return kota.get();
    }

    public SimpleStringProperty kotaProperty() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota.set(kota);
    }
}

