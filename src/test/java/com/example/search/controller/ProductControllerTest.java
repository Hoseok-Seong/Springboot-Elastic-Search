package com.example.search.controller;

import com.example.search.document.Product;
import com.example.search.repository.ProductRepository;
import org.json.JSONArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mockMvc;

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

    @Test
    @DisplayName("제목으로 검색하기")
    public void findByTitle() throws Exception {
        // given
        String title = "아이엠";

        // when
        ResultActions resultActions = mockMvc
                .perform(post("/products/titles")
                .content(title).contentType(MediaType.APPLICATION_JSON));

        String searchResult = resultActions.andReturn().getResponse().getContentAsString();

        System.out.println(searchResult);

        JSONArray jsonArray = new JSONArray(searchResult);

        int length = jsonArray.length();

        System.out.println("JSON 배열의 길이: " + length);
    }

    @Test
    @DisplayName("특정 카테고리로 검색하기")
    public void findByCategory() throws Exception {
        // given
        String category = "가구/인테리어";

        // when
        ResultActions resultActions = mockMvc
                .perform(post("/products/categories")
                        .content(category).contentType(MediaType.APPLICATION_JSON));

        String searchResult = resultActions.andReturn().getResponse().getContentAsString();

//        System.out.println(searchResult);

        JSONArray jsonArray = new JSONArray(searchResult);

        int length = jsonArray.length();

        System.out.println("JSON 배열의 길이: " + length);
    }

    @Test
    @DisplayName("특정 카테고리 제외하고 검색하기")
    public void findByCategoryNot() throws Exception {
        // given
        String category = "가구/인테리어";

        // when
        ResultActions resultActions = mockMvc
                .perform(post("/products/CategoryNot")
                        .content(category).contentType(MediaType.APPLICATION_JSON));

        String searchResult = resultActions.andReturn().getResponse().getContentAsString();

//        System.out.println(searchResult);

        JSONArray jsonArray = new JSONArray(searchResult);

        int length = jsonArray.length();

        System.out.println("JSON 배열의 길이: " + length);
    }
}
