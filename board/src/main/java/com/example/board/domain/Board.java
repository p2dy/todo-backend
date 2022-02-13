package com.example.board.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import java.util.UUID;

@Value
@EqualsAndHashCode
@ToString
public class Board {

    UUID uniqueId;

    public static Board create(UUID uniqueId) {
        return new Board(uniqueId);
    }
}
