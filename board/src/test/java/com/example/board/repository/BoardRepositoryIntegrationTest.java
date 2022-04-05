package com.example.board.repository;

import com.example.board.domain.Board;
import com.example.board.domain.BoardId;
import com.example.core.domain.Title;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.example.core.domain.BoardFixtures.BOARD_TO_CREATE;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenExceptionOfType;

class BoardRepositoryIntegrationTest {

    private BoardRepository underTest;

    @BeforeEach
    void setUp() {
        underTest = new BoardRepository();
    }

    @Test
    void create_ReadAll() {
        underTest.create(BOARD_TO_CREATE);
        var board2 = underTest.create(Board.create(BoardId.of(UUID.randomUUID()), Title.of("AnotherBoard")));

        then(underTest.readAll()).containsExactlyInAnyOrder(BOARD_TO_CREATE, board2);
    }

    @Test
    void create_Throws_ForDuplicate() {
        underTest.create(BOARD_TO_CREATE);

        thenExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> underTest.create(BOARD_TO_CREATE))
                .withMessageContaining("board with id %s already exists".formatted(BOARD_TO_CREATE.getId().getValue()));
    }

    @Test
    void readBy_IsEmpty() {
        then(underTest.readBy(BOARD_TO_CREATE.getId())).isEmpty();
    }

    @Test
    void readBy() {
        var board = underTest.create(BOARD_TO_CREATE);

        then(underTest.readBy(BOARD_TO_CREATE.getId())).isPresent().contains(board);
    }

    @Test
    void readAll_IsEmpty() {
        then(underTest.readAll()).isEmpty();
    }
}