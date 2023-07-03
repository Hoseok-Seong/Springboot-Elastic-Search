package com.example.search.service;

import com.example.search.document.Product;
import com.example.search.operation.ProductOperation;
import com.example.search.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductOperation productOperation;

    private final ProductRepository productRepository;

    public String save(Product product) {
        return productOperation.save(product);
    }

    public void delete(String id) {
        productOperation.delete(id);
    }

    public Product findById(String id) {
        return productOperation.findById(id);
    }

    public List<Product> findByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> findByContent(String content) {
        return productRepository.findByContent(content);
    }

    public List<Product> findByTitleAndContent(String title, String content) {
        return productRepository.findByTitleAndContent(title, content);
    }

    public List<Product> findByTitleOrContent(String title, String content) {
        return productRepository.findByTitleOrContent(title, content);
    }

    public List<Product> findByCategoryNot(String category) {
        return productRepository.findByCategoryNot(category);
    }

    public List<Product> findByPriceBetween(Integer from, Integer to) {
        return productRepository.findByPriceBetween(from, to);
    }

    public List<Product> findByPriceLessThan(Integer to) {
        return productRepository.findByPriceLessThan(to);
    }

    public List<Product> findByPriceLessThanEqual(Integer to) {
        return productRepository.findByPriceLessThanEqual(to);
    }

    public List<Product> findByPriceGreaterThan(Integer from) {
        return productRepository.findByPriceGreaterThan(from);
    }

    public List<Product> findByPriceGreaterThanEqual(Integer from) {
        return productRepository.findByPriceGreaterThanEqual(from);
    }

    public SearchHits<Product> titleMatchPhrase(String title) {
        return productOperation.titleMatchPhrase(title);
    }

    public SearchHits<Product> contentMatchPhrase(String content) {
        return productOperation.contentMatchPhrase(content);
    }
}
