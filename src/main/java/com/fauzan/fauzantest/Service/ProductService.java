package com.fauzan.fauzantest.Service;

import com.fauzan.fauzantest.core.IService;
import com.fauzan.fauzantest.model.Product;
import com.fauzan.fauzantest.repositories.ProductRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductService implements IService<Product> {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ResponseEntity<Object> findBelow10000(HttpServletRequest request) {

        List<Product> list = productRepo.cariHarga();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data", list);

        return ResponseEntity.ok(map);
    }

    @Override
    public ResponseEntity<Object> findAbove10000Name(HttpServletRequest request) {
        List<Product> list = productRepo.findAll();
        List<String> listNama = getNama(list);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data", listNama);

        return ResponseEntity.ok(map);
    }

    public List<String> getNama(List<Product> products) {
        return products.stream()
                .filter(u -> u.getHarga() > 10000)
                .map(Product::getNama)
                .toList();
    }

}
