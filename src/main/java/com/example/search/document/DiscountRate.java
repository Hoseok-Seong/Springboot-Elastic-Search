package com.example.search.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;

@Getter
@Setter
public class DiscountRate {
    @Field(name="gte")
    private Integer from = 0;

    @Field(name="lte")
    private Integer to = 100;
}
