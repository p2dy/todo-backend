package com.example.board.events;

import com.example.board.domain.Board;
import com.example.board.domain.BoardId;
import lombok.Value;

@Value
public class CreatedBoardEvent {
    Board board;

    public static CreatedBoardEvent of(Board board) {
        return new CreatedBoardEvent(board);
    }

    public BoardId getId() {
        return getBoard().getId();
    }
}
