package com.example.task.domain;

import com.example.core.ReadRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.core.domain.TaskFixture.ADDED_TASK;
import static com.example.core.domain.TaskFixture.TASK_TO_ADD;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ReadTaskServiceTest {

    @InjectMocks
    private ReadTaskService underTest;

    @Mock
    private ReadRepository<TaskId, Task> repository;

    @Test
    void readBy_ReturnsEmpty() {
        then(underTest.readBy(TASK_TO_ADD.getTaskId())).isEmpty();
    }

    @Test
    void readBy() {
        given(repository.readBy(TASK_TO_ADD.getTaskId())).willReturn(Optional.of(ADDED_TASK));

        var task = underTest.readBy(TASK_TO_ADD.getTaskId());

        then(task).contains(ADDED_TASK);
    }
}