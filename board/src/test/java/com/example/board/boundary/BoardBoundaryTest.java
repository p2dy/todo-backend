package com.example.board.boundary;

import com.example.board.domain.Board;
import com.example.board.domain.BoardId;
import com.example.core.domain.IdempotentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.board.boundary.BoardDtoFixture.boardToCreate;
import static com.example.board.boundary.BoardDtoFixture.createdBoard;
import static com.example.board.domain.BoardFixture.BOARD_TO_CREATE;
import static com.example.board.domain.BoardFixture.CREATED_BOARD;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BoardBoundaryTest {

    @InjectMocks
    BoardBoundary underTest;

    @Mock
    private IdempotentService<BoardId, Board> service;

    @Test
    void create() {
        given(service.createIdempotent(BOARD_TO_CREATE)).willReturn(CREATED_BOARD);

        var board = underTest.createBoard(boardToCreate());

        then(board).usingRecursiveComparison().isEqualTo(createdBoard());
    }

}