package com.learnspringboot.shop.service;

import com.learnspringboot.shop.models.Product;
import com.learnspringboot.shop.models.User;
import com.learnspringboot.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author tamvo
 * @created 15/02/2020 - 2:47 PM
 */

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void createProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }

    public void updateProduct(Product product, long id){
        Product testProduct = productRepository.findById(id).get();
        product.setId(id);
        productRepository.save(product);
    }

    public Collection<Product> getProducts(){
        return productRepository.findAll();
    }
}
