package com.emlakcepte.controller;

import com.emlakcepte.request.ProductRequest;
import com.emlakcepte.response.ProductResponse;
import com.emlakcepte.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/users/{id}")
    public ProductResponse getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping
    public ProductResponse add(@RequestBody ProductRequest productRequest) {
        return productService.add(productRequest);
    }
}
