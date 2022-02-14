package com.example.board.domain;

import java.util.UUID;

public class BoardIdProvider {
    public BoardId generate() {
        return BoardId.of(UUID.randomUUID());
    }
}
