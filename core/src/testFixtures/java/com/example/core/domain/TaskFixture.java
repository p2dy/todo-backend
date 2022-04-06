package com.example.core.domain;

import com.example.task.domain.Task;
import com.example.task.domain.TaskId;

import java.util.UUID;

import static com.example.core.domain.BoardFixtures.CREATED_BOARD;

public class TaskFixture {
    public static final TaskId TASK_ID_TO_ADD = TaskId.of(java.util.UUID.fromString("72528b18-f53d-4d3c-8850-7ccff5b02b97"));
    public static final TaskId ADDED_TASK_ID = TaskId.of(UUID.fromString("8d7a3ec8-91d4-4c79-85ec-3054744fc9db"));
    public static final Task TASK_TO_ADD = Task.create(CREATED_BOARD.getId(), TASK_ID_TO_ADD, Title.of("Wash the dishes"));
    public static final Task ADDED_TASK = Task.create(CREATED_BOARD.getId(), ADDED_TASK_ID, Title.of("Clean up the laundry room"));
}
