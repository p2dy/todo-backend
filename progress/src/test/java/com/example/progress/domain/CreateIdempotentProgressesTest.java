package com.example.progress.domain;

import com.example.board.domain.BoardId;
import com.example.core.domain.CreateService;
import com.example.core.domain.ReadService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.core.domain.ProgressFixtures.PROGRESSES_TO_CREATE;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateIdempotentProgressesTest {

    @InjectMocks
    private CreateIdempotentProgresses underTest;

    @Mock
    private ReadService<BoardId, Progresses> readService;

    @Mock
    private CreateService<Progresses> createService;

    @Test
    void create() {
        given(createService.create(PROGRESSES_TO_CREATE)).willReturn(PROGRESSES_TO_CREATE);

        then(underTest.create(PROGRESSES_TO_CREATE)).isEqualTo(PROGRESSES_TO_CREATE);
    }

    @Test
    void create_Idempotent() {
        given(readService.readBy(PROGRESSES_TO_CREATE.getId())).willReturn(Optional.of(PROGRESSES_TO_CREATE));

        then(underTest.create(PROGRESSES_TO_CREATE)).isEqualTo(PROGRESSES_TO_CREATE);
        verify(createService, never()).create(any());
    }

}