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

        System.out.println("검색된 Document 길이: " + length);
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

        System.out.println("검색된 Document 길이: " + length);
    }

    @Test
    @DisplayName("특정 카테고리 제외하고 검색하기")
    public void findByCategoryNot() throws Exception {
        // given
        String category = "가구/인테리어";

        // when
        ResultActions resultActions = mockMvc
                .perform(post("/products/categoryNot")
                        .content(category).contentType(MediaType.APPLICATION_JSON));

        String searchResult = resultActions.andReturn().getResponse().getContentAsString();

//        System.out.println(searchResult);

        JSONArray jsonArray = new JSONArray(searchResult);

        int length = jsonArray.length();

        System.out.println("검색된 Document 길이: " + length);
    }

    @Test
    @DisplayName("특정 가격대 이상, 특정 가격대 이하로 검색하기")
    public void findByPriceBetween() throws Exception {
        // given
        Integer from = 5000;
        Integer to = 30000;

        // when
        ResultActions resultActions = mockMvc
                .perform(post("/products/prices/between?from="+from+"&to="+to));

        String searchResult = resultActions.andReturn().getResponse().getContentAsString();

//        System.out.println(searchResult);

        JSONArray jsonArray = new JSONArray(searchResult);

        int length = jsonArray.length();

        System.out.println("검색된 Document 길이: " + length);
    }

    @Test
    @DisplayName("특정 가격 미만으로 검색하기")
    public void findByPriceLessThan() throws Exception {
        // given
        Integer to = 30000;

        // when
        ResultActions resultActions = mockMvc
                .perform(post("/products/prices/lessThan?to="+to));

        String searchResult = resultActions.andReturn().getResponse().getContentAsString();

//        System.out.println(searchResult);

        JSONArray jsonArray = new JSONArray(searchResult);

        int length = jsonArray.length();

        System.out.println("검색된 Document 길이: " + length);
    }

    @Test
    @DisplayName("특정 가격 이하로 검색하기")
    public void findByPriceLessThanEqual() throws Exception {
        // given
        Integer to = 30000;

        // when
        ResultActions resultActions = mockMvc
                .perform(post("/products/prices/lessThanEqual?to="+to));

        String searchResult = resultActions.andReturn().getResponse().getContentAsString();

//        System.out.println(searchResult);

        JSONArray jsonArray = new JSONArray(searchResult);

        int length = jsonArray.length();

        System.out.println("검색된 Document 길이: " + length);
    }
    @Test
    @DisplayName("특정 가격 초과로 검색하기")
    public void findByPriceGreaterThan() throws Exception {
        // given
        Integer from = 5000;

        // when
        ResultActions resultActions = mockMvc
                .perform(post("/products/prices/greaterThan?from="+from));

        String searchResult = resultActions.andReturn().getResponse().getContentAsString();

//        System.out.println(searchResult);

        JSONArray jsonArray = new JSONArray(searchResult);

        int length = jsonArray.length();

        System.out.println("검색된 Document 길이: " + length);
    }

    @Test
    @DisplayName("특정 가격 이상으로 검색하기")
    public void findByPriceGreaterThanEqual() throws Exception {
        // given
        Integer from = 5000;

        // when
        ResultActions resultActions = mockMvc
                .perform(post("/products/prices/greaterThanEqual?from="+from));

        String searchResult = resultActions.andReturn().getResponse().getContentAsString();

//        System.out.println(searchResult);

        JSONArray jsonArray = new JSONArray(searchResult);

        int length = jsonArray.length();

        System.out.println("검색된 Document 길이: " + length);
    }

//    @Test
//    @DisplayName("공백 포함, 순서 고려해서 제목으로 검색하기")
//    public void titleMatchPhrase() throws Exception {
//        // given
//        String title = "아이엠";
//
//        // when
//        ResultActions resultActions = mockMvc
//                .perform(post("/products/titleMatchPhrase")
//                        .content(title).contentType(MediaType.APPLICATION_JSON));
//
//        String searchResult = resultActions.andReturn().getResponse().getContentAsString();
//
////        System.out.println(searchResult);
//
//        JSONArray jsonArray = new JSONArray(searchResult);
//
//        int length = jsonArray.length();
//
//        System.out.println("검색된 Document 길이: " + length);
//    }
}
