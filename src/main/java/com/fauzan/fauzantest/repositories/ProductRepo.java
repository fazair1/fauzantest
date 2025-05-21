package com.fauzan.fauzantest.repositories;

import com.fauzan.fauzantest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query(value = "SELECT x FROM Product x WHERE harga < 10000")
    public List<Product> cariHarga();

}
