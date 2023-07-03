package com.example.search.batch;

import com.example.search.Entity.Product;
import com.example.search.repository.JpaRepository;
import com.example.search.repository.ProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CsvWriter implements ItemWriter<Product> {

    private final ProductRepository productRepository;

    private final JpaRepository jpaRepository;

    @Override
    public void write(@NonNull Chunk<? extends Product> chunk) {
        jpaRepository.saveAll(chunk);
//        this.productRepository.saveAll(chunk);
    }
}
