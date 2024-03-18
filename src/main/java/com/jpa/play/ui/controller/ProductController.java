package com.jpa.play.ui.controller;


import com.jpa.play.persistence.domain.Product;
import com.jpa.play.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/product")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("/{id}")
    public Optional<Product> getProductById(Long productId){
        return  productService.getProduct(productId);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return  productService.getAllProducts();
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product){
        return  productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Product product) {
        productService.deleteProduct(product);
    }




}
