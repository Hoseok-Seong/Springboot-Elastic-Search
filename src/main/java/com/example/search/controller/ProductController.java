package com.example.search.controller;

import com.example.search.document.Product;
import com.example.search.service.ProductService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/products/TitlesAndContents")
    public List<Product> findByTitleAndContent(@RequestBody String title, String content) {
        return productService.findByTitleAndContent(title, content);
    }

    @PostMapping("/products/TitlesOrContents")
    public List<Product> findByTitleOrContent(@RequestBody String title, String content) {
        return productService.findByTitleOrContent(title, content);
    }

    @PostMapping("/products/CategoryNot")
    public List<Product> findByCategoryNot(@RequestBody String category) {
        return productService.findByCategoryNot(category);
    }
}
