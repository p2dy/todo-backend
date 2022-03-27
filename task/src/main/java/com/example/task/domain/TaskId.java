package com.example.task.domain;

import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class TaskId {
    UUID value;
    UUID boardId;
}
