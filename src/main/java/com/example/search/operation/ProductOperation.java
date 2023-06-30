package com.example.search.operation;

import com.example.search.document.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;

@RequiredArgsConstructor
public class ProductOperation {

    private final ElasticsearchOperations elasticsearchOperations;

    public String save(Product product) {
        Product savedEntity = elasticsearchOperations.save(product);
        return savedEntity.toString();
    }

    public void delete(String id) {
        elasticsearchOperations.delete(id, Product.class);
    }

    public Product findById(String id) { return elasticsearchOperations.get(id, Product.class);}

    // 공백 포함, 순서 고려 검색
    public SearchHits<Product> titleMatchPhrase(String title) {
        Query query = NativeQuery.builder()
                .withQuery(q -> q.matchPhrase(m -> m.field("content").query(title)))
                .build();

        SearchHits<Product> searchHits = elasticsearchOperations.search(query, Product.class);
        return searchHits;
    }

    // 공백 포함, 순서 고려 검색
    public SearchHits<Product> contentMatchPhrase(String content) {
        Query query = NativeQuery.builder()
                .withQuery(q -> q.matchPhrase(m -> m.field("content").query(content)))
                .build();

        SearchHits<Product> searchHits = elasticsearchOperations.search(query, Product.class);
        return searchHits;
    }
}
