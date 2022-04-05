package com.example.task.boundary;

import com.example.task.domain.ReadBacklogTaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.example.core.boundary.BoardDtoFixture.createdBoard;
import static com.example.core.boundary.TaskDtoFixtures.givenAddedTask;
import static com.example.core.domain.BoardFixtures.CREATED_BOARD;
import static com.example.core.domain.TaskFixture.ADDED_BACKLOG_TASK;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BacklogTaskResolverTest {

    @InjectMocks
    private BacklogTaskResolver underTest;

    @Mock
    private ReadBacklogTaskService service;

    @Test
    void tasks_DelegatesToService() {
        given(service.readAllBy(CREATED_BOARD.getId())).willReturn(List.of(ADDED_BACKLOG_TASK));

        var tasks = underTest.backlogTasks(createdBoard());

        then(tasks).containsExactly(givenAddedTask());
    }
}