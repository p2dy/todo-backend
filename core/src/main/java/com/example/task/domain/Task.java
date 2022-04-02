package com.example.task.domain;

import com.example.board.domain.BoardId;
import com.example.core.domain.Title;
import com.example.core.domain.WithBoardId;
import lombok.Value;

@Value
public class Task implements WithBoardId {
    TaskId taskId;
    Title title;

    public static Task create(TaskId taskId, Title title) {
        return new Task(taskId, title);
    }

    @Override
    public BoardId getBoardId() {
        return taskId.getBoardId();
    }
}
