package com.example.board.domain;

import com.example.core.domain.Title;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
@EqualsAndHashCode
public class Board {

    BoardId id;
    Title title;

    public static Board create(BoardId boardId, Title title) {
        return new Board(boardId, title);
    }

    public Board with(BoardId id) {
        return Board.create(BoardId.of(id.getValue()), this.getTitle());
    }
}

