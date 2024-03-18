package com.jpa.play.service.impl;

import com.jpa.play.persistence.domain.Product;
import com.jpa.play.persistence.repository.ProductRepository;
import com.jpa.play.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Override
    public Optional<Product> getProduct(final Long productId) {
        return productRepository.findById(productId);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(long productId , final Product product) {

        // get the product from DB by id
        // And update it with the value passed in .
        // call save to flush it to DB .

        Product existingProduct = productRepository.findById(productId).get(); //

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setProductType(existingProduct.getProductType());

        // SaveAndFlush commits immediately to DB . save(T) syncrhonizes the session later as part of Transaction strategy.
        //SaveAndFlush is used when we want to have the reference to the saved entity immediately ie - the value is required for say someother
        // entity based operation.

        return productRepository.saveAndFlush(existingProduct);

    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }


}
