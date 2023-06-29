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

//    public void bulkSave(Product product) {
//
//        BulkRequest.Builder br = new BulkRequest.Builder();
//
//        for (int i = 1; i < 1001; i++) {
//            br.operations(op -> op
//                    .index(idx -> idx
//                            .index("products")
//                            .document(product)
//                    )
//            );
//        }
//
//        elasticsearchOperations.save(br);
//    }

    public void delete(String id) {
        elasticsearchOperations.delete(id, Product.class);
    }

    public void deleteAll() {
    }

    public void matchAll() {}

    public void match() {}

    public void matchPhrase() {}

    public void boolMust() {}

    public void boolMustNot() {}

    // 가중치 높은 순 검색
    public void boolShould() {}

    // 정확값 검색
    public void boolFilter() {}

    public void range() {}


}
