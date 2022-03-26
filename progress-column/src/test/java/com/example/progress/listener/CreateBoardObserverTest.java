package com.example.progress.listener;

import com.example.progress.domain.CreateProgressColumnService;
import com.example.progress.domain.ProgressColumnFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateBoardObserverTest {

    @InjectMocks
    CreateBoardObserver observer;

    @Mock
    private CreateProgressColumnService service;

    @Test
    void onBoardCreate_delegatesToService() {
        observer.on(ProgressColumnFixture.EVENT_OF_CREATED_BOARD);

        verify(service).create(ProgressColumnFixture.DEFAULT_PROGRESS_COLUMNS);
    }
}