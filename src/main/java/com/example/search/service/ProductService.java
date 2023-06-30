package com.example.search.service;

import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import com.example.search.document.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ElasticsearchOperations elasticsearchOperations;

    public String save(Product product) {
        Product savedEntity = elasticsearchOperations.save(product);
        return savedEntity.toString();
    }

    public void delete(String id) {
        elasticsearchOperations.delete(id, Product.class);
    }
}
