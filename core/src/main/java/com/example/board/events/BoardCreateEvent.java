package com.example.board.events;

import com.example.board.domain.Board;
import lombok.Value;

@Value
public class BoardCreateEvent {
    Board board;

    public static BoardCreateEvent eventOf(Board board) {
        return new BoardCreateEvent(board);
    }
}
