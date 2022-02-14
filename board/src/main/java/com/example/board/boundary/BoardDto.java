package com.example.board.boundary;

import com.example.board.domain.Board;
import lombok.Data;

import java.util.UUID;

@Data
public class BoardDto {
    private UUID uniqueId;

    public static BoardDto of(Board model) {
        var boardDto = new BoardDto();
        boardDto.setUniqueId(model.getUniqueId());
        return boardDto;
    }

    public Board model() {
        return Board.createEmpty();
    }
}
