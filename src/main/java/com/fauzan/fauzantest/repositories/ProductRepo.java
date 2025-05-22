package com.fauzan.fauzantest.repositories;

import com.fauzan.fauzantest.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    public List<Product> findByNamaContainsIgnoreCase(String nama);
    public Page<Product> findByNamaContainsIgnoreCase(String nama, Pageable pageable);

    @Query(value = "SELECT x FROM Product x WHERE lower(x.productCategory.nama) LIKE lower(concat('%',?1,'%'))")
    public List<Product> cariCategory(String nama);
    @Query(value = "SELECT x FROM Product x WHERE lower(x.productCategory.nama) LIKE lower(concat('%',?1,'%'))")
    public Page<Product> cariCategory(String nama, Pageable pageable);

    @Query(value = "SELECT x FROM Product x WHERE harga < 10000")
    public List<Product> cariHarga();

}
