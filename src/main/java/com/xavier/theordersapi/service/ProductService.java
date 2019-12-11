package com.xavier.theordersapi.service;

import com.xavier.theordersapi.model.Product;
import com.xavier.theordersapi.repository.ProductRepository;
import com.xavier.theordersapi.service.exception.ProducrNotFoundException;
import com.xavier.theordersapi.service.exception.ProductExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductService(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(final Product product) {
        verifyIfExist(product);
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        verifyIfNotExist(id);
        return productRepository.getOne(id);
    }

    public void delete(Long id) {
        verifyIfNotExist(id);
        productRepository.deleteById(id);
    }

    private void verifyIfNotExist(Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        if (!foundProduct.isPresent()) {
           throw new ProducrNotFoundException();
        }
    }

    private void verifyIfExist(Product product) {
        Optional<Product> foundProduct = productRepository.findByProductName(product.getProductName());
        if (foundProduct.isPresent() && (product.isNew() || isUpdatingToADifferentProduct(product, foundProduct))) {
            throw new ProductExistException();
        }
    }

    private boolean isUpdatingToADifferentProduct(Product product, Optional<Product> foundProduct) {
        return product.exists() && !product.equals(foundProduct);
    }
}
