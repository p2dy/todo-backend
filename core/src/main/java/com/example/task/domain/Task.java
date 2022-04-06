package com.example.task.domain;

import com.example.board.domain.BoardId;
import com.example.core.domain.Title;
import com.example.core.domain.WithBoardReference;
import lombok.Value;

@Value(staticConstructor = "create")
public class Task implements WithBoardReference {
    TaskId id;
    BoardId boardReference;
//    ProgressId progressReference;
    Title title;

    public boolean references(BoardId boardId) {
        return getBoardReference().equals(boardId);
    }

    @Override
    public BoardId getBoardReference() {
        return boardReference;
    }
}
