package com.example.search;

import com.example.search.controller.ProductController;
import com.example.search.document.Product;
import com.example.search.operation.ProductOperation;
import com.example.search.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("ES에 1건 저장하기")
    public void save() {

        Point point = new Point(10.132, 11.332);

        // given
        Product product = Product.builder()
                .title("상품명")
                .category("카테고리")
                .content("상품 소개")
                .price(1000)
                .discountRate(10)
                .location(point)
                .build();

        // when
        productRepository.save(product);

        // then

    }
}
