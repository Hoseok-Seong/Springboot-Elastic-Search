package com.example.search.batch;

import com.example.search.Entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {
    private final CsvReader csvReader;
    private final CsvWriter csvWriter;

    private static final int chunkSize = 1000;

    @Bean
    public Job csvBatchJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) throws IOException {
        System.out.println("job bean 실행");
        return new JobBuilder("csvBatchJob", jobRepository)
                .start(csvBatchStep(jobRepository, platformTransactionManager))
                .build();
    }

    @Bean
    public Step csvBatchStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) throws IOException {
        System.out.println("step bean 실행");
        return new StepBuilder("csvBatchStep", jobRepository)
                .<Product, Product>chunk(chunkSize, platformTransactionManager)
                .reader(csvReader.csvFileItemReader())
                .writer(csvWriter)
                .build();
    }
}
