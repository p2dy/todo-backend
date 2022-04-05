package com.example.task.domain;

import com.example.board.domain.BoardId;
import lombok.Value;

@Value(staticConstructor = "create")
public class BacklogTask {
    BoardId boardId;
    Task task;

    public BacklogTaskId getId() {
        return BacklogTaskId.of(task.getId(), boardId);
    }
}
