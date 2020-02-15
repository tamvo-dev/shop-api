package com.learnspringboot.shop.controller;

import com.learnspringboot.shop.models.Product;
import com.learnspringboot.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author tamvo
 * @created 15/02/2020 - 2:58 PM
 */

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<Object> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return new ResponseEntity<>("Create product success", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Delete product success", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProduct(@PathVariable("id") long id, @RequestBody Product product){
        productService.updateProduct(product, id);
        return new ResponseEntity<>("Update product success", HttpStatus.OK);
    }
}
