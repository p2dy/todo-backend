package com.example;

import com.example.board.domain.Board;
import com.example.board.domain.CreateBoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BoardBoundaryTest {

    public static final UUID BOARD_ID_VALUE = java.util.UUID.randomUUID();
    public static final Board BOARD = Board.create(BOARD_ID_VALUE);
    private static final Board CREATED_BOARD = Board.create(UUID.randomUUID());

    @InjectMocks
    BoardBoundary underTest;

    @Mock
    private CreateBoardService createService;

    @Test
    void getOrCreate() {
        given(createService.create(BOARD)).willReturn(CREATED_BOARD);

        var board = underTest.create(BOARD);

        then(board).isEqualTo(CREATED_BOARD);
    }
}