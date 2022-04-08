package com.example.core.domain;

import com.example.task.domain.Task;
import com.example.task.domain.TaskId;

import java.util.UUID;

import static com.example.core.domain.BoardFixtures.CREATED_BOARD;
import static com.example.core.domain.ProgressFixtures.*;
import static com.example.progress.domain.ProgressId.EMPTY_PROGRESS_REFERENCE;

public class TaskFixture {
    public static final TaskId TASK_ID_TO_ADD = TaskId.of(java.util.UUID.fromString("72528b18-f53d-4d3c-8850-7ccff5b02b97"));
    public static final TaskId ADDED_TASK_ID = TaskId.of(UUID.fromString("8d7a3ec8-91d4-4c79-85ec-3054744fc9db"));
    public static final Task TASK_TO_ADD = Task.builder()
            .id(TASK_ID_TO_ADD)
            .title(Title.of("Wash the dishes"))
            .boardReference(CREATED_BOARD.getId())
            .progressReference(TODO.getId())
            .build();
    public static final Task TASK_WITH_EMPTY_PROGRESS_REFERENCE = TASK_TO_ADD.toBuilder().progressReference(EMPTY_PROGRESS_REFERENCE).build();
    public static final Task ADDED_TASK = Task.builder()
            .id(ADDED_TASK_ID)
            .title(Title.of("Clean up the laundry room"))
            .boardReference(CREATED_BOARD.getId())
            .progressReference(DONE.getId())
            .build();

}
