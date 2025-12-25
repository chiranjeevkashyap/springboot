package com.chiranjeevkashyap.springboot.repositories;

import com.chiranjeevkashyap.springboot.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByTitle(String s);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime of);

    List<ProductEntity> findByQuantityAndPrice(int i, BigDecimal i1);

    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    @Query("select p from ProductEntity p where p.sku = ?1 and p.price = ?2")
    Optional<ProductEntity> findBySkuAndPrice(String sku, BigDecimal price);

    List<ProductEntity> findByOrderByPrice();

    List<ProductEntity> findByOrderByQuantity();

    List<ProductEntity> findBy(Sort sort);
}
