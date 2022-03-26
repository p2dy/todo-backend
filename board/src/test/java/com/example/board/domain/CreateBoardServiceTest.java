package com.example.board.domain;

import com.example.board.events.CreatedBoardEvent;
import com.example.core.domain.CreateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.enterprise.event.Event;

import static com.example.board.domain.BoardFixture.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateBoardServiceTest {

    @InjectMocks
    private CreateBoardService underTest;

    @Mock
    private CreateRepository<Board> repository;

    @Mock
    private Event<CreatedBoardEvent> boardCreateEvent;

    @Test
    void create() {
        given(repository.create(BOARD_TO_CREATE)).willReturn(CREATED_BOARD);

        var board = underTest.create(BOARD_TO_CREATE);

        then(board).isEqualTo(CREATED_BOARD);
        verify(boardCreateEvent).fire(EVENT_OF_CREATED_BOARD);
    }
}