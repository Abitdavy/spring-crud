package com.example.karyawan.karyawan;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table
public class KaryawanModel {
    @Id
    private int id;
    private String nama;
    private LocalDate tanggal_masuk;
    private BigInteger no_handphone;
    private BigInteger limit_imbursement;
    private Date createdOn;
    private LocalDateTime updatedOn;

    public KaryawanModel(){

    }

    public KaryawanModel(int id, String nama, LocalDate tanggal_masuk, BigInteger no_handphone, BigInteger limit_imbursement, Date createdOn, LocalDateTime updatedOn) {
        this.id = id;
        this.nama = nama;
        this.tanggal_masuk = tanggal_masuk;
        this.no_handphone = no_handphone;
        this.limit_imbursement = limit_imbursement;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public KaryawanModel(String nama, LocalDate tanggal_masuk, BigInteger no_handphone, BigInteger limit_imbursement, Date createdOn, LocalDateTime updatedOn) {
        this.nama = nama;
        this.tanggal_masuk = tanggal_masuk;
        this.no_handphone = no_handphone;
        this.limit_imbursement = limit_imbursement;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public LocalDate getTanggal_masuk() {
        return tanggal_masuk;
    }

    public void setTanggal_masuk(LocalDate tanggal_masuk) {
        this.tanggal_masuk = tanggal_masuk;
    }

    public BigInteger getNo_handphone() {
        return no_handphone;
    }

    public void setNo_handphone(BigInteger no_handphone) {
        this.no_handphone = no_handphone;
    }

    public BigInteger getLimit_imbursement() {
        return limit_imbursement;
    }

    public void setLimit_imbursement(BigInteger limit_imbursement) {
        this.limit_imbursement = limit_imbursement;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "KaryawanModel{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", tanggal_masuk=" + tanggal_masuk +
                ", no_handphone=" + no_handphone +
                ", limit_imbursement=" + limit_imbursement +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
