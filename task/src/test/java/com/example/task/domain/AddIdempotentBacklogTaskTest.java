package com.example.task.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.core.domain.TaskFixture.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AddIdempotentBacklogTaskTest {

    @InjectMocks
    private AddIdempotentTask underTest;

    @Mock
    private ReadBacklogTaskService readService;

    @Mock
    private AddBacklogTaskService addService;

    @Test
    void add_Idempotent() {
        given(readService.readBy(BACKLOG_TASK_TO_ADD.getId())).willReturn(Optional.of(ADDED_BACKLOG_TASK));

        var task = underTest.add(BACKLOG_TASK_TO_ADD);

        then(task).isEqualTo(ADDED_BACKLOG_TASK);
        verify(addService, never()).add(any());
    }

    @Test
    void add() {
        given(readService.readBy(BACKLOG_TASK_TO_ADD.getId())).willReturn(Optional.empty());
        given(addService.add(BACKLOG_TASK_TO_ADD)).willReturn(ADDED_BACKLOG_TASK);

        var task = underTest.add(BACKLOG_TASK_TO_ADD);

        then(task).isEqualTo(ADDED_BACKLOG_TASK);
    }

}