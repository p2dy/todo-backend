package com.example.task.domain;

import com.example.core.CreateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.core.domain.TaskFixture.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AddBacklogTaskServiceTest {

    @InjectMocks
    private AddBacklogTaskService underTest;

    @Mock
    private CreateRepository<BacklogTask> repository;

    @Test
    void add() {
        given(repository.create(BACKLOG_TASK_TO_ADD)).willReturn(ADDED_BACKLOG_TASK);

        var task = underTest.add(BACKLOG_TASK_TO_ADD);

        then(task).isEqualTo(ADDED_BACKLOG_TASK);
    }
}