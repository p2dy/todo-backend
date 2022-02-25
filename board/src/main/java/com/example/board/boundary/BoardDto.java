package com.example.board.boundary;

import com.example.board.domain.Board;
import com.example.board.domain.Title;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.UUID;

import static com.example.board.domain.BoardId.defaultId;

@Data
public class BoardDto {
    @Setter(value = AccessLevel.PACKAGE)
    private UUID uniqueId;

    private String title;

    public static BoardDto of(Board model) {
        var boardDto = new BoardDto();
        boardDto.setUniqueId(model.getId().getValue());
        boardDto.setTitle(model.getTitle().getValue());
        return boardDto;
    }

    public Board model() {
        return Board.create(defaultId(), Title.of(title));
    }

}
