package com.example.board.boundary;

import com.example.board.domain.CreateBoardService;
import lombok.AllArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public final class BoardBoundary {
    private final CreateBoardService createService;

    public BoardDto create(BoardDto board) {
        var model = createService.create(board.model());
        return BoardDto.of(model);
    }

}