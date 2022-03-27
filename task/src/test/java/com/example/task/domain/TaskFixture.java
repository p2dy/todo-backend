package com.example.task.domain;

import com.example.board.domain.BoardId;
import com.example.core.domain.Title;

import java.util.UUID;

public class TaskFixture {
    public static final BoardId BOARD_ID = BoardId.of(UUID.fromString("4db67305-7885-4557-8ae9-960815f64ce1"));
    public static final TaskId TASK_TO_ADD_ID = TaskId.of(UUID.fromString("72528b18-f53d-4d3c-8850-7ccff5b02b97"), BOARD_ID.getValue());
    public static final Task TASK_TO_ADD = new Task(TASK_TO_ADD_ID, Title.of("Wash the dishes"));
    public static final TaskId CREATED_TASK_ID = TaskId.of(UUID.fromString("8d7a3ec8-91d4-4c79-85ec-3054744fc9db"), BOARD_ID.getValue());
    public static final Task CREATED_TASK = new Task(CREATED_TASK_ID, Title.of("Clean up the laundry room"));
}
