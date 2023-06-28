package com.example.search.controller;

import com.example.search.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@EnableElasticsearchRepositories
public class BoardController {

    private final ElasticsearchOperations elasticsearchOperations;

    @GetMapping("/")
    public String home() {
        return "ok";
    }

    @PostMapping("/boards")
    public String save(@RequestBody Board board) {
        Board savedEntity = elasticsearchOperations.save(board);
        System.out.println(savedEntity.getId());
        System.out.println(savedEntity);
        return savedEntity.getId();
    }

    @GetMapping("/boards/{id}")
    public Board findById(@PathVariable("id")  String id) {
        Board board = elasticsearchOperations.get(id, Board.class);
        return board;
    }
}
