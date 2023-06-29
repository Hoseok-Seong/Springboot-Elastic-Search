package com.example.search.repository;

import com.example.search.document.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByTitle(String title);

    List<Product> findByCategory(String category);

    List<Product> findByContent(String content);

    List<Product> findByTitleAndContent(String title, String content);

    List<Product> findByTitleOrContent(String title, String content);

    List<Product> findByPriceBetween(Integer from, Integer to);

}
