package com.example.board.domain;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class BoardIdProvider {
    public BoardId generate() {
        return BoardId.of(UUID.randomUUID());
    }
}
