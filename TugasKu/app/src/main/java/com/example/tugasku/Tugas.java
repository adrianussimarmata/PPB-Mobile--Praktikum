package com.example.tugasku;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_tugas")
public class Tugas {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String judul_tugas;
    private String tgl_tugas_masuk;
    private String tgl_deadline;
    private String catatan;

    public Tugas(String judul_tugas, String tgl_tugas_masuk, String tgl_deadline, String catatan) {
        this.judul_tugas = judul_tugas;
        this.tgl_tugas_masuk = tgl_tugas_masuk;
        this.tgl_deadline = tgl_deadline;
        this.catatan = catatan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul_tugas() {
        return judul_tugas;
    }

    public void setJudul_tugas(String judul_tugas) {
        this.judul_tugas = judul_tugas;
    }

    public String getTgl_tugas_masuk() {
        return tgl_tugas_masuk;
    }

    public void setTgl_tugas_masuk(String tgl_tugas_masuk) {
        this.tgl_tugas_masuk = tgl_tugas_masuk;
    }

    public String getTgl_deadline() {
        return tgl_deadline;
    }

    public void setTgl_deadline(String tgl_deadline) {
        this.tgl_deadline = tgl_deadline;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}
