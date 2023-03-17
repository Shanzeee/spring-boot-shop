package com.brvsk.shop.service.interfaces;

import com.brvsk.shop.model.Product;

import java.util.List;

public interface ProductServiceInterface {
    Product saveProduct(Product product);

    void deleteProduct(Long id);

    List<Product> findAllProduct();
}
