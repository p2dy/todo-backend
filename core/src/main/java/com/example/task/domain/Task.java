package com.example.task.domain;

import com.example.core.domain.Title;
import lombok.Value;

@Value
public class Task {
    TaskId taskId;
    Title title;

    public static Task create(TaskId taskId, Title title) {
        return new Task(taskId, title);
    }
}
