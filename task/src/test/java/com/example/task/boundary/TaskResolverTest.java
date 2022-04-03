package com.example.task.boundary;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.core.domain.ProgressFixtures.progressesToCreate;

@ExtendWith(MockitoExtension.class)
class TaskResolverTest {

    @InjectMocks
    private TaskResolver underTest;

    @Test
    void tasks_DelegatesToService() {
        underTest.tasks(progressesToCreate());
    }
}