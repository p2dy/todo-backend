package com.example.board.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardId {

    UUID value;

    public static BoardId of(UUID value) {
        return new BoardId(value);
    }
}
