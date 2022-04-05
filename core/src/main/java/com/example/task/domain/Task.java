package com.example.task.domain;

import com.example.core.domain.Title;
import lombok.Value;

@Value(staticConstructor = "create")
public class Task {
    TaskId id;
    Title title;
}
