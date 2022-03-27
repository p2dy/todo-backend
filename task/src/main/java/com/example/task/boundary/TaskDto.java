package com.example.task.boundary;

import com.example.core.domain.Title;
import com.example.task.domain.Task;
import com.example.task.domain.TaskId;
import lombok.Data;

import java.util.UUID;

@Data
public class TaskDto {
    UUID uniqueId;
    String title;

    public static TaskDto from(Task task) {
        var taskId = task.getTaskId();
        var result = new TaskDto();
        result.setUniqueId(taskId.getValue());
        result.setTitle(task.getTitle().getValue());
        return result;
    }

    public Task model(UUID boardId) {
        return Task.create(TaskId.of(uniqueId, boardId), Title.of(title));
    }
}
