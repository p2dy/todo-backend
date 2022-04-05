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
class ReadTaskServiceTest {

    @InjectMocks
    private ReadTaskService underTest;

    @Mock
    private ReadRepository<TaskId, Task> repository;

    @Mock
    private ReadByBoardIdRepository<Task> readByBoardIdRepository;

    @Test
    void readBy_ReturnsEmpty() {
        then(underTest.readBy(TASK_TO_ADD.getId())).isEmpty();
    }

    @Test
    void readBy() {
        given(repository.readBy(TASK_TO_ADD.getId())).willReturn(Optional.of(ADDED_TASK));

        var task = underTest.readBy(TASK_TO_ADD.getId());

        then(task).contains(ADDED_TASK);
    }

    @Test
    void readAllBy() {
        given(readByBoardIdRepository.readAllBy(CREATED_BOARD.getId())).willReturn(List.of(ADDED_TASK, TASK_TO_ADD));

        var tasks = underTest.readAllBy(CREATED_BOARD.getId());

        then(tasks).containsExactlyInAnyOrder(ADDED_TASK, TASK_TO_ADD);
    }
}