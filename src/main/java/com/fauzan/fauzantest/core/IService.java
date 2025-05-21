package com.fauzan.fauzantest.core;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface IService<T> {

    public ResponseEntity<Object> findBelow10000(HttpServletRequest request);

    public ResponseEntity<Object> findAbove10000Name(HttpServletRequest request);

}
