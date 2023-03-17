package com.brvsk.shop.service;

import com.brvsk.shop.model.Product;
import com.brvsk.shop.repository.ProductRepository;
import com.brvsk.shop.service.interfaces.ProductServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements ProductServiceInterface {

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product){
        product.setCreateTime(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }
}

