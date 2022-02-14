package com.example.board.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static com.example.board.domain.BoardFixture.BOARD;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenExceptionOfType;

class BoardRepositoryTest {

    private BoardRepository underTest;

    @BeforeEach
    void setUp() {
        underTest = new BoardRepository();
    }

    @Test
    void create() {
        var board = underTest.create(BOARD);

        then(board).isEqualTo(BOARD);
    }

    @Test
    void createThrowsForDuplicate() {
        underTest.create(BOARD);

        thenExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> underTest.create(BOARD))
                .withMessageContaining("board with id %s already exists".formatted(BOARD.getId().getValue()));
    }
}