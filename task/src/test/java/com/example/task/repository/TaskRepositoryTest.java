package com.example.task.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.core.domain.TaskFixture.ADDED_TASK;
import static com.example.core.domain.TaskFixture.TASK_TO_ADD;
import static org.assertj.core.api.BDDAssertions.then;

class TaskRepositoryTest {

    private TaskRepository underTest;

    @BeforeEach
    void setUp() {
        underTest = new TaskRepository();
    }

    @Test
    void create() {
        underTest.create(TASK_TO_ADD);
        underTest.create(ADDED_TASK);

        then(underTest.values()).containsExactly(TASK_TO_ADD, ADDED_TASK);
    }

    @Test
    void readBy() {
        underTest.create(TASK_TO_ADD);

        then(underTest.readBy(TASK_TO_ADD.getTaskId())).contains(TASK_TO_ADD);
    }

    @Test
    void readBy_ReturnsEmpty() {
        then(underTest.readBy(TASK_TO_ADD.getTaskId())).isEmpty();
    }
}