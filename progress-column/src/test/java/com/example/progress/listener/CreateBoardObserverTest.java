package com.example.progress.listener;

import com.example.core.domain.UniqueIdProvider;
import com.example.progress.domain.CreateProgressColumnService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.progress.domain.ProgressColumnFixture.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateBoardObserverTest {

    @InjectMocks
    CreateBoardObserver observer;

    @Mock
    private CreateProgressColumnService service;

    @Mock
    private UniqueIdProvider uniqueIdProvider;

    @Test
    void onBoardCreate_delegatesToService() {
        given(uniqueIdProvider.generate()).willReturn(TODO_COLUMN_ID.getValue(), DONE_COLUMN_ID.getValue());

        observer.on(EVENT_OF_CREATED_BOARD);

        verify(service).create(DEFAULT_PROGRESS_COLUMNS);
    }
}