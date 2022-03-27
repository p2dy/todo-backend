package com.example.progress.listener;

import com.example.core.CreatedListener;
import com.example.progress.domain.CreateIdempotentProgresses;
import com.example.progress.domain.ProgressIdProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.progress.domain.ProgressFixture.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateDefaultProgressesForBoardTest {

    @InjectMocks
    CreateDefaultProgressesForBoard underTest;

    @Mock
    private CreateIdempotentProgresses service;

    @Mock
    private ProgressIdProvider progressIdProvider;

    @Test
    void implementsCreatedListeners() {
        then(underTest).isInstanceOf(CreatedListener.class);
    }

    @Test
    void onBoardCreate_delegatesToService() {
        given(progressIdProvider.generate()).willReturn(TODO_ID, DONE_ID);

        underTest.onCreated(CREATED_BOARD);

        verify(service).create(DEFAULT_PROGRESSES);
    }
}