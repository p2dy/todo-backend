package com.example.progress.domain;

import com.example.core.domain.Repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.progress.domain.ProgressFixture.PROGRESSES_TO_CREATE;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateProgressServiceTest {

    @InjectMocks
    private CreateProgressService underTest;

    @Mock
    private Repository<Progresses> repository;

    @Test
    void create() {
        underTest.create(PROGRESSES_TO_CREATE);

        verify(repository).create(PROGRESSES_TO_CREATE);
    }
}