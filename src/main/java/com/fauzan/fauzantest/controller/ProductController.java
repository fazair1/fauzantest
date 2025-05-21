package com.fauzan.fauzantest.controller;

import com.fauzan.fauzantest.Service.ProductService;
import com.fauzan.fauzantest.model.Product;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Object> findBelow10000(HttpServletRequest request) {

        return productService.findBelow10000(request);
    }

    @GetMapping("/nama")
    public ResponseEntity<Object> getNama(HttpServletRequest request) {

        return productService.findAbove10000Name(request);
    }

}
