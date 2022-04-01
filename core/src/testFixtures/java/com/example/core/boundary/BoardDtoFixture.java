package com.example.core.boundary;

import com.example.board.boundary.BoardDto;

import static com.example.core.domain.BoardFixtures.*;

public class BoardDtoFixture {

    public static BoardDto boardToCreate() {
        var dto = new BoardDto();
        dto.setUniqueId(BOARD_TO_CREATE.getId().getValue());
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
