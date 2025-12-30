package com.chiranjeevkashyap.springboot.repositories;

import com.chiranjeevkashyap.springboot.entities.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String s);

    List<Product> findByCreatedAtAfter(LocalDateTime of);

    List<Product> findByQuantityAndPrice(int i, BigDecimal i1);

    Optional<Product> findByTitleAndPrice(String title, BigDecimal price);

    @Query("select p from Product p where p.sku = ?1 and p.price = ?2")
    Optional<Product> findBySkuAndPrice(String sku, BigDecimal price);

    List<Product> findByOrderByPrice();

    List<Product> findByOrderByQuantity();

    List<Product> findBy(Sort sort);
}
