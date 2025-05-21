package com.fauzan.fauzantest.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MstProduct")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDProduct")
    private Long id;

    @Column(name = "NamaProduct")
    private String nama;

    @Column(name = "HargaProduct")
    private int harga;

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
