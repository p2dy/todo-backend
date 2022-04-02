package com.example.core.domain;

import com.example.task.domain.Task;
import com.example.task.domain.TaskId;

import java.util.UUID;

import static com.example.core.domain.BoardFixtures.CREATED_BOARD;

public class TaskFixture {
    private static final TaskId TASK_TO_ADD_ID = TaskId.of(UUID.fromString("72528b18-f53d-4d3c-8850-7ccff5b02b97"), CREATED_BOARD.getId());
    private static final TaskId ADDED_TASK_ID = TaskId.of(UUID.fromString("8d7a3ec8-91d4-4c79-85ec-3054744fc9db"), CREATED_BOARD.getId());
    public static final Task TASK_TO_ADD = new Task(TASK_TO_ADD_ID, Title.of("Wash the dishes"));
    public static final Task ADDED_TASK = new Task(ADDED_TASK_ID, Title.of("Clean up the laundry room"));
}
