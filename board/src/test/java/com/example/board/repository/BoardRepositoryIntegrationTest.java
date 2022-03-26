package com.example.board.repository;

import com.example.board.domain.Board;
import com.example.board.domain.BoardId;
import com.example.core.domain.Title;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.example.board.domain.BoardFixture.BOARD_TO_CREATE;
import static org.assertj.core.api.BDDAssertions.then;

class BoardRepositoryIntegrationTest {

    private BoardRepository underTest;

    @BeforeEach
    void setUp() {
        underTest = new BoardRepository();
    }

    @Test
    void create() {
        var board = underTest.create(BOARD_TO_CREATE);

        then(board).isEqualTo(BOARD_TO_CREATE);
    }

    @Test
    void createMultiple() {
        var board1 = underTest.create(BOARD_TO_CREATE);
        var board2 = underTest.create(Board.create(BoardId.of(UUID.randomUUID()), Title.of("Foo")));

        then(underTest.getValues()).containsExactly(board1, board2);
    }

    @Test
    void createIsIdempotent() {
        underTest.create(BOARD_TO_CREATE);
        underTest.create(BOARD_TO_CREATE);

        then(underTest.getValues()).containsExactly(BOARD_TO_CREATE);
    }
}