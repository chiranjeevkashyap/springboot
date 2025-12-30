package com.chiranjeevkashyap.springboot.controllers;

import com.chiranjeevkashyap.springboot.entities.Product;
import com.chiranjeevkashyap.springboot.exceptions.ResourceNotFoundException;
import com.chiranjeevkashyap.springboot.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("no products available.");
        }
        return ResponseEntity.ok(products);
    }

    /*@GetMapping
    public List<ProductEntity> findBy(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") int page
    ) {
        *//*return productRepository.findBy(Sort.by(sortBy));*//*
        *//*return productRepository.findBy(Sort.by(Sort.Order.desc(sortBy)));*//*
        Pageable pageable = PageRequest.of(page, 5, Sort.by(sortBy));
        return productRepository.findAll(pageable).getContent();
    }*/
}
