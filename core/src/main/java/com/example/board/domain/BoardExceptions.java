package com.example.board.domain;

import javax.ws.rs.NotFoundException;
import java.util.function.Supplier;

public class BoardExceptions {
    public static Supplier<NotFoundException> notFoundFor(BoardId boardId) {
        return () -> new NotFoundException("can not find board for uniqueId %s".formatted(boardId));
    }
}
