package com.example.task.domain;

import com.example.board.domain.BoardId;
import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class TaskId {
    UUID value;
    BoardId boardId;

    public UUID getBoardIdValue() {
        return getBoardId().getValue();
    }
}
