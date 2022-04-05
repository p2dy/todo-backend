package com.example.task.domain;

import com.example.board.domain.BoardId;
import com.example.core.domain.Title;
import com.example.core.domain.WithBoardId;
import lombok.Value;

@Value(staticConstructor = "create")
public class Task implements WithBoardId {
    TaskId id;
    BoardId boardReference;
    Title title;

    public boolean references(BoardId boardId) {
        return getBoardReference().equals(boardId);
    }

    @Override
    public BoardId getBoardId() {
        return boardReference;
    }
}
