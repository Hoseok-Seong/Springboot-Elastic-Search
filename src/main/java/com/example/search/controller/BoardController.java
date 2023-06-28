package com.example.search.controller;

import com.example.search.document.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@EnableElasticsearchRepositories
public class BoardController {

    private final ElasticsearchOperations elasticsearchOperations;

    @GetMapping("/")
    public String home() {
        return "ok";
    }

    @PostMapping("/boards")
    public String save(@RequestBody Product product) {
        Product savedEntity = elasticsearchOperations.save(product);
        System.out.println(savedEntity.getId());
        System.out.println(savedEntity);
        return savedEntity.getId();
    }

    @GetMapping("/boards/{id}")
    public Product findById(@PathVariable("id")  String id) {
        Product product = elasticsearchOperations.get(id, Product.class);
        return product;
    }
}
