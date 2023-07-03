package com.example.search.controller;

import com.example.search.document.Product;
import com.example.search.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

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
        return productService.findById(id);
    }

    @DeleteMapping("/products")
    public void delete(@RequestBody String id) {
        productService.delete(id);
    }

    @PostMapping("/products/titles")
    public List<Product> findByTitle(@RequestBody String title) {
        return productService.findByTitle(title);
    }

    @PostMapping("/products/categories")
    public List<Product> findByCategory(@RequestBody String category) {
        return productService.findByCategory(category);
    }

    @PostMapping("/products/contents")
    public List<Product> findByContent(@RequestBody String content) {
        return productService.findByContent(content);
    }

    @PostMapping("/products/titlesAndContents")
    public List<Product> findByTitleAndContent(@RequestBody String title, String content) {
        return productService.findByTitleAndContent(title, content);
    }

    @PostMapping("/products/titlesOrContents")
    public List<Product> findByTitleOrContent(@RequestBody String title, String content) {
        return productService.findByTitleOrContent(title, content);
    }

    @PostMapping("/products/categoryNot")
    public List<Product> findByCategoryNot(@RequestBody String category) {
        return productService.findByCategoryNot(category);
    }

    @PostMapping("/products/prices/between")
    public List<Product> findByPriceBetween(Integer from, Integer to) {
        return productService.findByPriceBetween(from, to);
    }

    @PostMapping("/products/prices/lessThan")
    public List<Product> findByPriceLessThan(Integer to) {
        return productService.findByPriceLessThan(to);
    }

    @PostMapping("/products/prices/lessThanEqual")
    public List<Product> findByPriceLessThanEqual(Integer to) {
        return productService.findByPriceLessThanEqual(to);
    }

    @PostMapping("/products/prices/greaterThan")
    public List<Product> findByPriceGreaterThan(Integer from) {
        return productService.findByPriceGreaterThan(from);
    }

    @PostMapping("/products/prices/greaterThanEqual")
    public List<Product> findByPriceGreaterThanEqual(Integer from) {
        return productService.findByPriceGreaterThanEqual(from);
    }

    @PostMapping("/products/titleMatchPhrase")
    public SearchHits<Product> titleMatchPhrase(@RequestBody String title) {
        return productService.titleMatchPhrase(title);
    }

    @PostMapping("/products/contentMatchPhrase")
    public SearchHits<Product> contentMatchPhrase(@RequestBody String content) {
        return productService.contentMatchPhrase(content);
    }
}
