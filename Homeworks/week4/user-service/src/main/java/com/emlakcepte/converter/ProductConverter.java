package com.emlakcepte.converter;

import com.emlakcepte.model.Product;
import com.emlakcepte.request.ProductRequest;
import com.emlakcepte.response.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ProductConverter {
    Date date = new Date();
    Date expired = new Date(date.getTime() + (1000L * 60 * 60 * 24 * 30));
    Long orderNo = 123456789L;

    public ProductResponse convert(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setOrderNo(product.getOrderNo());
        productResponse.setName(product.getName());
        productResponse.setQuantity(product.getQuantity());
        productResponse.setCreatedDate(date);
        productResponse.setExpiredDate(expired);
        productResponse.setUsers(product.getUsers());
        return productResponse;
    }

    public Product convert(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setOrderNo(orderNo++);
        product.setCreatedDate(date);
        product.setExpiredDate(expired);
        return product;
    }

}
