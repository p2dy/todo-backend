package com.example.board.boundary;

import static com.example.board.domain.BoardFixture.CREATED_BOARD;

public class BoardDtoFixture {
    public static BoardDto givenBoardToCreate() {
        return new BoardDto();
    }

    public static BoardDto givenCreatedBoard() {
        var boardDto = new BoardDto();
        boardDto.setUniqueId(CREATED_BOARD.getUniqueId());
        return boardDto;
    }
}
