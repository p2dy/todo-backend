package com.example.board.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardId {

    private static final UUID DEFAULT_ID_VALUE = UUID.fromString("0-0-0-0-0");

    UUID value;

    public static BoardId defaultId() {
        return of(DEFAULT_ID_VALUE);
    }

    public static BoardId of(UUID value) {
        return new BoardId(value);
    }
}
