package com.example.search.document;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.data.geo.Point;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Document(indexName = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
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
    @Field(type = FieldType.Integer)
    private Integer discountRate;
    @GeoPointField
    private Point location;
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
}
