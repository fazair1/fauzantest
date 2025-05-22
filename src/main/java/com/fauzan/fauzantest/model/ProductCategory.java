package com.fauzan.fauzantest.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MstProductCategory")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCategory")
    private Long id;

    @Column(name = "Nama", nullable = false, length = 50, unique = true)
    private String nama;

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
