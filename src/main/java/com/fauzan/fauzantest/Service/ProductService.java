package com.fauzan.fauzantest.Service;

import com.fauzan.fauzantest.core.IService;
import com.fauzan.fauzantest.dto.validation.ValProductDTO;
import com.fauzan.fauzantest.model.Product;
import com.fauzan.fauzantest.repositories.ProductRepo;
import com.fauzan.fauzantest.util.TransformPagination;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements IService<Product> {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TransformPagination transformPagination;

    @Override
    public ResponseEntity<Object> save(Product product, HttpServletRequest request) {
        try {
            productRepo.save(product);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Gagal Disimpan");
        }
        return ResponseEntity.ok("Berhasil Disimpan");

    }

    @Override
    public ResponseEntity<Object> update(Long id, Product product, HttpServletRequest request) {
        try {
            Optional<Product> optionalProduct = productRepo.findById(id);

            Product nextProduct = optionalProduct.get();
            nextProduct.setNama(product.getNama());
            nextProduct.setHarga(product.getHarga());
            nextProduct.setProductCategory(product.getProductCategory());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Gagal Diupdate");
        }
        return ResponseEntity.ok("Berhasil Diupdate");

    }

    @Override
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
        try {
            Optional<Product> optionalProduct = productRepo.findById(id);

            productRepo.deleteById(id);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Gagal Didelete");
        }
        return ResponseEntity.ok("Berhasil Didelete");
    }

    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {
        Page<Product> page = null;
        List<Product> list = null;
        page = productRepo.findAll(pageable);
        list = page.getContent();

        return ResponseEntity.ok(transformPagination.transformPagination(list,page,null,null));
    }

    @Override
    public ResponseEntity<Object> findById(Long id, HttpServletRequest request) {
        Optional<Product> optionalProduct = null;
        Map<String,Object> map = new HashMap<String,Object>();

        try {
            optionalProduct = productRepo.findById(id);
            Product product = optionalProduct.get();
            map.put("data", product);

        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Data Tidak Ditemukan");
        }
        return ResponseEntity.ok(map);
    }

    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, String columnName, String value, HttpServletRequest request) {
        Page<Product> page = null;
        List<Product> list = null;

        switch (columnName) {
            case "nama": page = productRepo.findByNamaContainsIgnoreCase(value, pageable);break;
            case "category": page = productRepo.cariCategory(value, pageable);break;
            default: page = productRepo.findAll(pageable);
        }
        list = page.getContent();

        return ResponseEntity.ok(transformPagination.transformPagination(list,page,columnName,value));
    }

    public ResponseEntity<Object> findBelow10000(HttpServletRequest request) {

        List<Product> list = productRepo.cariHarga();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data", list);

        return ResponseEntity.ok(map);
    }

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

    public Product convertToEntity (ValProductDTO valProductDTO) {
        Product product = modelMapper.map(valProductDTO, Product.class);
        return product;
    }

}
