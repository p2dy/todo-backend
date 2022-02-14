package com.example.board.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import java.util.UUID;

@Value
@ToString
@EqualsAndHashCode
public class Board {

    UUID uniqueId;
    BoardId id;

    public static Board createEmpty() {
        return create(UUID.fromString("0-0-0-0-0"));
    }

    public static Board create(UUID uniqueId) {
        return new Board(uniqueId, BoardId.of(uniqueId));
    }

    public BoardId getId() {
        return id;
    }

    public Board with(BoardId id) {
        return Board.create(id.getValue());
    }
}

