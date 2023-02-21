package com.emlakcepte.service;

import com.emlakcepte.converter.ProductConverter;
import com.emlakcepte.model.Product;
import com.emlakcepte.repository.ProductRepository;
import com.emlakcepte.request.ProductRequest;
import com.emlakcepte.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductConverter productConverter;


    public ProductResponse getById(Long id) {
        return productConverter.convert(productRepository.getById(id));
    }

    public ProductResponse add(ProductRequest productRequest) {
        Product product = productConverter.convert(productRequest);
        return productConverter.convert(productRepository.save(product));
    }
}
