package com.example.task.domain;

import com.example.board.domain.BoardId;
import com.example.core.domain.Title;
import com.example.core.domain.WithBoardId;
import com.example.progress.domain.ProgressId;
import lombok.Value;

@Value
public class Task implements WithBoardId {
    TaskId taskId;
    Title title;
    ProgressId progressReference;

    public static Task create(TaskId taskId, Title title, ProgressId progressReference) {
        return new Task(taskId, title, progressReference);
    }

    @Override
    public BoardId getBoardId() {
        return taskId.getBoardId();
    }
}
