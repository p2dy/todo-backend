package com.example.task.boundary;

import com.example.task.domain.AddIdempotentTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.task.domain.TaskFixture.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AddTaskBoundaryTest {

    @InjectMocks
    private AddTaskBoundary underTest;

    @Mock
    private AddIdempotentTask service;

    @Test
    void add() {
        given(service.add(TASK_TO_ADD)).willReturn(CREATED_TASK);

        var task = underTest.add(givenTaskToAdd(), BOARD_ID.getValue());

        then(task).usingRecursiveComparison().isEqualTo(givenAddedTask());
    }

    public static TaskDto givenAddedTask() {
        var result = new TaskDto();
        result.setUniqueId(CREATED_TASK.getTaskId().getValue());
        result.setTitle(CREATED_TASK.getTitle().getValue());
        return result;
    }

    public static TaskDto givenTaskToAdd() {
        var result = new TaskDto();
        result.setUniqueId(TASK_TO_ADD.getTaskId().getValue());
        result.setTitle(TASK_TO_ADD.getTitle().getValue());
        return result;
    }
}