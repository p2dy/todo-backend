package com.example.board.domain;

import com.example.core.domain.CreateService;
import com.example.core.domain.ReadService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.core.domain.BoardFixtures.BOARD_TO_CREATE;
import static com.example.core.domain.BoardFixtures.CREATED_BOARD;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateIdempotentBoardTest {

    @InjectMocks
    private CreateIdempotentBoard underTest;

    @Mock
    private ReadService<BoardId, Board> readService;

    @Mock
    private CreateService<Board> createService;

    @Test
    void create() {
        given(createService.create(BOARD_TO_CREATE)).willReturn(CREATED_BOARD);

        underTest.create(BOARD_TO_CREATE);

        then(underTest.create(BOARD_TO_CREATE)).isEqualTo(CREATED_BOARD);
    }

    @Test
    void create_Idempotent() {
        given(readService.readBy(BOARD_TO_CREATE.getId())).willReturn(Optional.of(CREATED_BOARD));

        underTest.create(BOARD_TO_CREATE);

        then(underTest.create(BOARD_TO_CREATE)).isEqualTo(CREATED_BOARD);
        verify(createService, never()).create(any());
    }
}