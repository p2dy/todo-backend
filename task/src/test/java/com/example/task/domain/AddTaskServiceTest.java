package com.example.task.domain;

import com.example.board.domain.BoardId;
import com.example.core.CreateRepository;
import com.example.core.domain.ProgressFixtures;
import com.example.core.domain.ReadService;
import com.example.progress.domain.Progresses;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.core.domain.ProgressFixtures.DEFAULT_PROGRESSES;
import static com.example.core.domain.ProgressFixtures.TODO;
import static com.example.core.domain.TaskFixture.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AddTaskServiceTest {

    @InjectMocks
    private AddTaskService underTest;

    @Mock
    private CreateRepository<Task> repository;

    @Mock
    private ReadService<BoardId, Progresses> readService;

    @Test
    void add() {
        given(repository.create(TASK_TO_ADD)).willReturn(ADDED_TASK);

        var task = underTest.add(TASK_TO_ADD);

        then(task).isEqualTo(ADDED_TASK);
    }

    @Test
    void add_WithEmptyProgressReference_WillUseFirstProgress() {
        given(readService.readBy(TASK_WITH_EMPTY_PROGRESS_REFERENCE.getBoardReference())).willReturn(Optional.of(DEFAULT_PROGRESSES));

        underTest.add(TASK_WITH_EMPTY_PROGRESS_REFERENCE);

        verify(repository).create(argThat(task -> task.getProgressReference().equals(TODO.getId())));
    }
}