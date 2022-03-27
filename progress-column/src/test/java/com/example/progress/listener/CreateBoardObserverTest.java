package com.example.progress.listener;

import com.example.progress.domain.ProgressIdProvider;
import com.example.progress.domain.CreateProgressService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.progress.domain.ProgressFixture.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateBoardObserverTest {

    @InjectMocks
    CreateBoardObserver observer;

    @Mock
    private CreateProgressService service;

    @Mock
    private ProgressIdProvider progressIdProvider;

    @Test
    void onBoardCreate_delegatesToService() {
        given(progressIdProvider.generate()).willReturn(TODO_ID, DONE_ID);

        observer.on(EVENT_OF_CREATED_BOARD);

        verify(service).create(DEFAULT_PROGRESSES);
    }
}