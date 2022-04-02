package com.example.task.boundary;

import com.example.core.boundary.TaskDtoFixtures;
import com.example.task.domain.AddIdempotentTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.core.boundary.BoardDtoFixture.createdBoard;
import static com.example.core.domain.TaskFixture.*;
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

        var task = underTest.addTask(TaskDtoFixtures.givenTaskToAdd(), createdBoard().getUniqueId());

        then(task).usingRecursiveComparison().isEqualTo(TaskDtoFixtures.givenAddedTask());
    }

}