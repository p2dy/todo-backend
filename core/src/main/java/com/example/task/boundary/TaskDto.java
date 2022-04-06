package com.example.task.boundary;

import com.example.board.domain.BoardId;
import com.example.core.domain.Title;
import com.example.task.domain.Task;
import com.example.task.domain.TaskId;
import lombok.Data;

import java.util.UUID;

@Data
public class TaskDto {
    UUID uniqueId;
    UUID boardReference;
    String title;

    public static TaskDto from(Task task) {
        var result = new TaskDto();
        result.setUniqueId(task.getId().getValue());
        result.setTitle(task.getTitle().getValue());
        result.setBoardReference(task.getBoardReference().getValue());
        return result;
    }

    public Task model() {
        return Task.create(TaskId.of(uniqueId), BoardId.of(boardReference), Title.of(title));
    }
}
