package com.example.task.domain;

import com.example.board.domain.BoardId;
import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class BacklogTaskId {
    TaskId taskId;
    BoardId boardId;

    public UUID getTaskIdValue() {
        return getTaskId().getValue();
    }

    public UUID getBoardIdValue() {
        return getBoardId().getValue();
    }
}
