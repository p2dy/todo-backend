package com.example.board.domain;

import com.example.core.domain.Title;
import com.example.core.domain.WithId;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
@EqualsAndHashCode
public class Board implements WithId<BoardId> {

    BoardId id;
    Title title;

    public static Board create(BoardId boardId, Title title) {
        return new Board(boardId, title);
    }

}

