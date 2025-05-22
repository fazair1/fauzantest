package com.fauzan.fauzantest.controller;

import com.fauzan.fauzantest.Service.ProductService;
import com.fauzan.fauzantest.dto.validation.ValProductDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody ValProductDTO valProductDTO, HttpServletRequest request) {
        return productService.save(productService.convertToEntity(valProductDTO), request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id,
                                         @Valid @RequestBody ValProductDTO valProductDTO, HttpServletRequest request) {
        return productService.update(id, productService.convertToEntity(valProductDTO), request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable(value = "id") Long id, HttpServletRequest request){
        return productService.delete(id,request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id, HttpServletRequest request) {
        return productService.findById(id, request);
    }

    @GetMapping
    public ResponseEntity<Object> findAll(HttpServletRequest request) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id"));

        return productService.findAll(pageable, request);
    }

    @GetMapping("/{sort}/{sortBy}/{page}")
    public ResponseEntity<Object> findByParam(
            @PathVariable(value = "sort") String sort,
            @PathVariable(value = "sortBy") String sortBy,
            @PathVariable(value = "page") Integer page,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "column") String column,
            @RequestParam(value = "value") String value,
            HttpServletRequest request){

        Pageable pageable = null;
        sortBy = sortColumnByMap(sortBy);
        switch (sort) {
            case "asc":pageable = PageRequest.of(page, size, Sort.by(sortBy));break;
            default: pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        }

        return productService.findByParam(pageable, column, value, request);
    }

    @GetMapping("/below")
    public ResponseEntity<Object> findBelow10000(HttpServletRequest request) {

        return productService.findBelow10000(request);
    }

    @GetMapping("/nama")
    public ResponseEntity<Object> getNama(HttpServletRequest request) {

        return productService.findAbove10000Name(request);
    }

    private String sortColumnByMap(String sortBy){
        switch (sortBy){
            case "nama":sortBy = "nama";break;
            case "category":sortBy = "category";break;
            default:sortBy = "id";
        }
        return sortBy;
    }

}
