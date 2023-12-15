package com.example.modul6.Latihan;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Mahasiswa {
    private final SimpleStringProperty nama;
    private final SimpleStringProperty NIM;
    private final SimpleStringProperty email;

    public Mahasiswa(String nama, String NIM, String email) {
        this.nama = new SimpleStringProperty(nama);
        this.NIM = new SimpleStringProperty(NIM);
        this.email = new SimpleStringProperty(email);
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
}

