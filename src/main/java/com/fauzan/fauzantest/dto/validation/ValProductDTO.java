package com.fauzan.fauzantest.dto.validation;

import com.fauzan.fauzantest.dto.relation.RelProductCategory;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ValProductDTO {

    @NotNull
    private String nama;

    @NotNull
    private int harga;

    @NotNull
    private RelProductCategory productCategory;

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public RelProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(RelProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
