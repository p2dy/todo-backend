package com.example.task.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.core.domain.TaskFixture.*;
import static org.assertj.core.api.BDDAssertions.then;

class BacklogTaskRepositoryTest {

    private BacklogTaskRepository underTest;

    @BeforeEach
    void setUp() {
        underTest = new BacklogTaskRepository();
    }

    @Test
    void create() {
        underTest.create(BACKLOG_TASK_TO_ADD);
        underTest.create(ADDED_BACKLOG_TASK);

        then(underTest.values()).containsExactly(TASK_TO_ADD, ADDED_TASK);
    }

    @Test
    void readBy() {
        underTest.create(BACKLOG_TASK_TO_ADD);

        then(underTest.readBy(BACKLOG_TASK_TO_ADD.getId())).contains(BACKLOG_TASK_TO_ADD);
    }

    @Test
    void readBy_ReturnsEmpty() {
        then(underTest.readBy(BACKLOG_TASK_TO_ADD.getId())).isEmpty();
    }
}