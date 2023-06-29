package com.example.search.controller;

import com.example.search.document.Product;
import com.example.search.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@EnableElasticsearchRepositories
public class ProductController {

    private final ElasticsearchOperations elasticsearchOperations;

    private final ProductService productService;

    @GetMapping("/")
    public String home() {
        return "ok";
    }

    @PostMapping("/products")
    public String save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable("id")  String id) {
        Product product = elasticsearchOperations.get(id, Product.class);
        return product;
    }

    @DeleteMapping("/products")
    public void delete(String id) {
        productService.delete(id);
    }

//    @PostMapping("/products/bulk")
//    public void bulkSave(@RequestBody Product product) {
//        productService.bulkSave(product);
//    }
}
