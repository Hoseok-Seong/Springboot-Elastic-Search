package com.example.search.controller;

import com.example.search.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final ElasticsearchOperations elasticsearchOperations;

    @GetMapping("/")
    public String home() {
        return "ok";
    }

    @PostMapping("/boards")
    public Long save(@RequestBody Board board) {
        Board savedEntity = elasticsearchOperations.save(board);
        return savedEntity.getId();
    }

    @GetMapping("/boards/{id}")
    public Board findById(@PathVariable("id")  Long id) {
        Board board = elasticsearchOperations.get(id.toString(), Board.class);
        return board;
    }
}
