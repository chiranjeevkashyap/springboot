package com.chiranjeevkashyap.springboot.controllers;

import com.chiranjeevkashyap.springboot.entities.ProductEntity;
import com.chiranjeevkashyap.springboot.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<ProductEntity> findBy(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") int page
    ) {
        /*return productRepository.findBy(Sort.by(sortBy));*/
        /*return productRepository.findBy(Sort.by(Sort.Order.desc(sortBy)));*/
        Pageable pageable = PageRequest.of(page, 5, Sort.by(sortBy));
        return productRepository.findAll(pageable).getContent();
    }
}
