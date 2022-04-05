package com.example.task.boundary;

import com.example.task.domain.AddIdempotentTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.core.boundary.BoardDtoFixture.createdBoard;
import static com.example.core.boundary.TaskDtoFixtures.*;
import static com.example.core.boundary.TaskDtoFixtures.givenTaskToAdd;
import static com.example.core.domain.TaskFixture.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AddTaskToBacklogBoundaryTest {

    @InjectMocks
    private AddTaskToBacklogBoundary underTest;

    @Mock
    private AddIdempotentTask service;

    @Test
    void add() {
        given(service.add(BACKLOG_TASK_TO_ADD)).willReturn(ADDED_BACKLOG_TASK);

        var task = underTest.addTask(givenTaskToAdd(), createdBoard().getUniqueId());

        then(task).usingRecursiveComparison().isEqualTo(givenAddedTask());
    }

}