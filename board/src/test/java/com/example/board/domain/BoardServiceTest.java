package com.example.board.domain;

import com.example.board.events.CreatedBoardEvent;
import com.example.core.domain.IdempotentService;
import com.example.core.domain.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.enterprise.event.Event;
import java.util.Optional;

import static com.example.board.domain.BoardFixture.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {

    private IdempotentService<BoardId, Board> underTest;

    @Mock
    private Repository<Board> repository;

    @Mock
    private Event<CreatedBoardEvent> boardCreateEvent;

    @BeforeEach
    void setUp() {
        underTest = new BoardService(repository, boardCreateEvent);
    }

    @Test
    void create() {
        given(repository.create(BOARD_TO_CREATE)).willReturn(CREATED_BOARD);

        var board = underTest.create(BOARD_TO_CREATE);

        then(board).isEqualTo(CREATED_BOARD);
        verify(boardCreateEvent).fire(EVENT_OF_CREATED_BOARD);
    }

    @Test
    void createIdempotent() {
        given(repository.create(BOARD_TO_CREATE)).willReturn(CREATED_BOARD);

        var board = underTest.createIdempotent(BOARD_TO_CREATE);

        then(board).isEqualTo(CREATED_BOARD);
        verify(boardCreateEvent).fire(EVENT_OF_CREATED_BOARD);
    }

    @Test
    void createIdempotent_existingModel() {
        given(repository.read(BOARD_TO_CREATE.getId())).willReturn(Optional.of(CREATED_BOARD));

        var board = underTest.createIdempotent(BOARD_TO_CREATE);

        then(board).isEqualTo(CREATED_BOARD);
        verify(repository, never()).create(any());
        verify(boardCreateEvent, never()).fire(any());
    }
}