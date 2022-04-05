package com.example.task.boundary;

import com.example.core.domain.Title;
import com.example.task.domain.BacklogTask;
import com.example.task.domain.Task;
import com.example.task.domain.TaskId;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class TaskDto {
    UUID uniqueId;
    String title;

    public static TaskDto from(Task task) {
        var result = new TaskDto();
        result.setUniqueId(task.getId().getValue());
        result.setTitle(task.getTitle().getValue());
        return result;
    }

    public static TaskDto from(BacklogTask backlogTask) {
        return from(backlogTask.getTask());
    }

    public Task model() {
        return Task.create(TaskId.of(uniqueId), Title.of(title));
    }
}
