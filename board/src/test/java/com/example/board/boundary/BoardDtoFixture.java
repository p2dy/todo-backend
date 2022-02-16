package com.example.board.boundary;

import static com.example.board.domain.BoardFixture.*;

public class BoardDtoFixture {

    public static BoardDto boardToCreate() {
        var dto = new BoardDto();
        dto.setTitle(BOARD_TO_CREATE.getTitle().getValue());
        return dto;
    }

    public static BoardDto createdBoard() {
        var dto = new BoardDto();
        dto.setUniqueId(CREATED_BOARD.getId().getValue());
        dto.setTitle(CREATED_BOARD.getTitle().getValue());
        return dto;
    }
}
