package com.example.board.boundary;

import com.example.board.domain.Board;
import com.example.board.domain.BoardId;
import com.example.core.domain.Title;
import lombok.Data;

import java.util.UUID;

@Data
public class BoardDto {
    private UUID uniqueId;
    private String title;

    public static BoardDto of(Board model) {
        var boardDto = new BoardDto();
        boardDto.setUniqueId(model.getId().getValue());
        boardDto.setTitle(model.getTitle().getValue());
        return boardDto;
    }

    public Board model() {
        return Board.create(BoardId.of(uniqueId), Title.of(title));
    }

}
