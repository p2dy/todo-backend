package com.example.board.boundary;

import com.example.board.domain.CreateIdempotentBoard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.core.boundary.BoardDtoFixture.boardToCreate;
import static com.example.core.boundary.BoardDtoFixture.createdBoard;
import static com.example.core.domain.BoardFixtures.BOARD_TO_CREATE;
import static com.example.core.domain.BoardFixtures.CREATED_BOARD;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CreateBoardBoundaryTest {

    @InjectMocks
    CreateBoardBoundary underTest;

    @Mock
    private CreateIdempotentBoard service;

    @Test
    void create() {
        given(service.create(BOARD_TO_CREATE)).willReturn(CREATED_BOARD);

        var board = underTest.createBoard(boardToCreate());

        then(board).usingRecursiveComparison().isEqualTo(createdBoard());
    }

}