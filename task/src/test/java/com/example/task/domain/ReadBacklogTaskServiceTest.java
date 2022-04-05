package com.example.task.domain;

import com.example.core.ReadByBoardIdRepository;
import com.example.core.ReadRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.example.core.domain.BoardFixtures.CREATED_BOARD;
import static com.example.core.domain.TaskFixture.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ReadBacklogTaskServiceTest {

    @InjectMocks
    private ReadBacklogTaskService underTest;

    @Mock
    private ReadRepository<BacklogTaskId, BacklogTask> repository;

    @Mock
    private ReadByBoardIdRepository<BacklogTask> readByBoardIdRepository;

    @Test
    void readBy_ReturnsEmpty() {
        then(underTest.readBy(BACKLOG_TASK_TO_ADD.getId())).isEmpty();
    }

    @Test
    void readBy() {
        given(repository.readBy(BACKLOG_TASK_TO_ADD.getId())).willReturn(Optional.of(ADDED_BACKLOG_TASK));

        var task = underTest.readBy(BACKLOG_TASK_TO_ADD.getId());

        then(task).contains(ADDED_BACKLOG_TASK);
    }

    @Test
    void readAllBy() {
        given(readByBoardIdRepository.readAllBy(ADDED_BACKLOG_TASK.getBoardId())).willReturn(List.of(ADDED_BACKLOG_TASK, BACKLOG_TASK_TO_ADD));

        var backlogTasks = underTest.readAllBy(CREATED_BOARD.getId());

        then(backlogTasks).containsExactlyInAnyOrder(ADDED_BACKLOG_TASK, BACKLOG_TASK_TO_ADD);
    }
}