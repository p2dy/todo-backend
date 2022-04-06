package com.example.core.boundary;

import com.example.task.boundary.TaskDto;

import static com.example.core.domain.BoardFixtures.CREATED_BOARD;
import static com.example.core.domain.TaskFixture.ADDED_TASK;
import static com.example.core.domain.TaskFixture.TASK_TO_ADD;

public class TaskDtoFixtures {
    public static TaskDto givenAddedTask() {
        var result = new TaskDto();
        result.setBoardReference(ADDED_TASK.getBoardReference().getValue());
        result.setUniqueId(ADDED_TASK.getId().getValue());
        result.setTitle(ADDED_TASK.getTitle().getValue());
        return result;
    }

    public static TaskDto givenTaskToAdd() {
        var result = new TaskDto();
        result.setBoardReference(TASK_TO_ADD.getBoardReference().getValue());
        result.setUniqueId(TASK_TO_ADD.getId().getValue());
        result.setTitle(TASK_TO_ADD.getTitle().getValue());
        return result;
    }
}
