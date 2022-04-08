package com.example.task.boundary;

import com.example.core.domain.TaskFixture;
import com.example.task.domain.AddIdempotentTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.core.boundary.TaskDtoFixtures.givenAddedTask;
import static com.example.core.boundary.TaskDtoFixtures.givenTaskToAdd;
import static com.example.core.domain.TaskFixture.ADDED_TASK;
import static com.example.core.domain.TaskFixture.TASK_TO_ADD;
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
        given(service.add(TASK_TO_ADD)).willReturn(ADDED_TASK);
        var task = underTest.addTask(givenTaskToAdd());

        then(task).usingRecursiveComparison().isEqualTo(givenAddedTask());
    }

    @Test
    void add_DelegatesWithEmptyProgressReference() {
        given(service.add(TaskFixture.TASK_WITH_EMPTY_PROGRESS_REFERENCE)).willReturn(ADDED_TASK);

        var task = underTest.addTask(taskWithoutProgressReference());

        then(task).usingRecursiveComparison().isEqualTo(givenAddedTask());
    }

    private TaskDto taskWithoutProgressReference() {
        var taskDto = givenTaskToAdd();
        taskDto.setProgressReference(null);
        return taskDto;
    }

}