package com.example.search.batch;

import com.example.search.Entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class CsvReader {

    @Bean
    public FlatFileItemReader<Product> csvFileItemReader() throws IOException {
        FlatFileItemReader<Product> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new ClassPathResource("csv/product.csv"));
        itemReader.setLinesToSkip(1); // header line skip
        itemReader.setEncoding("UTF-8"); // encoding

        DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer(",");
        delimitedLineTokenizer.setNames("category", "title", "price");
        lineMapper.setLineTokenizer(delimitedLineTokenizer);

        BeanWrapperFieldSetMapper<Product> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(Product.class);
        lineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        itemReader.setLineMapper(lineMapper);

        System.out.println("실행됨?1");
        System.out.println(itemReader.getName());
        ClassPathResource fileSystemResource = new ClassPathResource("csv/product.csv");
        System.out.println(fileSystemResource.contentLength());
        return itemReader;
    }
}
