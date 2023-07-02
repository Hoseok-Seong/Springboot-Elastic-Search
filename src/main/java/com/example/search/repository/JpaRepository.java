package com.example.search.repository;

import com.example.search.Entity.Product;

public interface JpaRepository extends org.springframework.data.jpa.repository.JpaRepository<Product, Long> {
}
