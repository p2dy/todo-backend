package com.example.progress.domain;

import com.example.core.domain.CreateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.progress.domain.ProgressColumnFixture.PROGRESS_COLUMNS_TO_CREATE;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateProgressServiceTest {

    @InjectMocks
    private CreateProgressService underTest;

    @Mock
    private CreateRepository<Progresses> repository;

    @Test
    void create() {
        underTest.create(PROGRESS_COLUMNS_TO_CREATE);

        verify(repository).create(PROGRESS_COLUMNS_TO_CREATE);
    }
}