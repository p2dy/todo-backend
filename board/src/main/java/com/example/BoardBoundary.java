package com.example;

import com.example.board.domain.Board;
import com.example.board.domain.CreateBoardService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BoardBoundary {

    @Inject
    CreateBoardService createService;

    public Board create(Board board) {
        return createService.create(board);
    }
}