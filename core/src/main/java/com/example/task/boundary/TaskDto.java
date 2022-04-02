package com.example.task.boundary;

import com.example.board.domain.BoardId;
import com.example.core.domain.Title;
import com.example.progress.domain.ProgressId;
import com.example.task.domain.Task;
import com.example.task.domain.TaskId;
import lombok.Data;

import java.util.UUID;

@Data
public class TaskDto {
    UUID uniqueId;
    String title;
    UUID progressReference;

    public static TaskDto from(Task task) {
        var taskId = task.getTaskId();
        var result = new TaskDto();
        result.setUniqueId(taskId.getValue());
        result.setTitle(task.getTitle().getValue());
        result.setProgressReference(task.getProgressReference().getValue());
        return result;
    }

    public Task model(BoardId boardId) {
        return Task.create(TaskId.of(uniqueId, boardId), Title.of(title), ProgressId.of(progressReference));
    }
}
