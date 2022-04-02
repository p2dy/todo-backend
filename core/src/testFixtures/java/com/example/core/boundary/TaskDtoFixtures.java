package com.example.core.boundary;

import com.example.task.boundary.TaskDto;

import static com.example.core.domain.TaskFixture.ADDED_TASK;
import static com.example.core.domain.TaskFixture.TASK_TO_ADD;

public class TaskDtoFixtures {
    public static TaskDto givenAddedTask() {
        var result = new TaskDto();
        result.setUniqueId(ADDED_TASK.getTaskId().getValue());
        result.setTitle(ADDED_TASK.getTitle().getValue());
        return result;
    }

    public static TaskDto givenTaskToAdd() {
        var result = new TaskDto();
        result.setUniqueId(TASK_TO_ADD.getTaskId().getValue());
        result.setTitle(TASK_TO_ADD.getTitle().getValue());
        return result;
    }
}
