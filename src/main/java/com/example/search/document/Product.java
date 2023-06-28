package com.example.search.document;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDateTime;

@Document(indexName = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Product {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String title;
    @Field(type = FieldType.Text)
    private String category;
    @Field(type = FieldType.Text)
    private String content;
    @Field(type = FieldType.Integer)
    private Integer price;
    @Field(type = FieldType.Integer_Range)
    private DiscountRate discountRate;
    @GeoPointField
    private GeoPoint geoPoint;
    @Field(type = FieldType.Date_Nanos, format = DateFormat.basic_date_time)
    private LocalDateTime createdAt;
}
