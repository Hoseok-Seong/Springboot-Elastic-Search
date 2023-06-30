package com.example.search.repository;

import com.example.search.document.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    // bool must
    List<Product> findByTitle(String title);

    // bool must
    List<Product> findByCategory(String category);

    // bool must
    List<Product> findByContent(String content);

    // bool must
    List<Product> findByTitleAndContent(String title, String content);

    // bool should
    List<Product> findByTitleOrContent(String title, String content);

    /// bool must not
    List<Product> findByCategoryNot(String category);

    // price range search
    List<Product> findByPriceBetween(Integer from, Integer to);

    List<Product> findByPriceLessThan(Integer to);

    List<Product> findByPriceLessThanEqual(Integer to);

    List<Product> findByPriceGreaterThan(Integer from);

    List<Product> findByPriceGreaterThanEqual(Integer from);

    // discountRate range search
    List<Product> findByDiscountRateBetween(Integer from, Integer to);

    List<Product> findByDiscountRateLessThan(Integer to);

    List<Product> findByDiscountRateLessThanEqual(Integer to);

    List<Product> findByDiscountRateGreaterThan(Integer from);

    List<Product> findByDiscountRateGreaterThanEqual(Integer from);

}
