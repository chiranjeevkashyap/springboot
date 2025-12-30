package com.chiranjeevkashyap.springboot;

import com.chiranjeevkashyap.springboot.entities.commerce.ProductEntity;
import com.chiranjeevkashyap.springboot.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class SpringBootCourseApplicationTests {
    @Autowired
    ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testRepository() {
        ProductEntity productEntity = ProductEntity.builder()
                .sku("ASH-5KG-RIC")
                .price(BigDecimal.valueOf(210))
                .title("Ashirvaad Select Basmati Rice 5kg")
                .quantity(130)
                .build();
        ProductEntity savedEntity = productRepository.save(productEntity);
        System.out.println(savedEntity);
    }

    @Test
    void getRepository() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        System.out.println(productEntityList);
    }

    @Test
    void findByTest() {
//		List<ProductEntity> productEntityList = productRepository.findByTitle("Fortune Sunflower Oil 1L");
//		LocalDateTime localDateTime = LocalDateTime.of(2025, 12, 25, 1, 1, 0);
//		List<ProductEntity> productEntityList = productRepository.findByCreatedAtAfter(localDateTime);
//		List<ProductEntity> productEntityList = productRepository.findByQuantityAndPrice(500, BigDecimal.valueOf(15));
//      Optional<ProductEntity> productEntity = productRepository.findByTitleAndPrice("Lifebuoy Soap 100g", BigDecimal.valueOf(15));
//		Optional<ProductEntity> productEntity = productRepository.findBySkuAndPrice("LIF-100G-SOP", BigDecimal.valueOf(15));
//		productEntity.ifPresent(System.out::println);
    }

    @Test
    void repositoryTest() {
        List<BigDecimal> list = productRepository.findByOrderByPrice().stream().map(ProductEntity::getPrice).toList();
        System.out.println(list);
    }
}
