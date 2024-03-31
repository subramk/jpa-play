package com.jpa.play.service;

import com.jpa.play.persistence.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    public Optional<Product> getProduct(Long productId);
    public List<Product> getAllProducts();
    public Product updateProduct(final long id, final Product productRequest);
    public void  deleteProduct(final Product product);
    public Product saveProduct(final Product product);

}
