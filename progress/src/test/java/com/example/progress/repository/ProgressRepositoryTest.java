package com.example.progress.repository;

import com.example.board.domain.BoardId;
import com.example.progress.domain.Progresses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static com.example.core.domain.ProgressFixtures.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenExceptionOfType;

class ProgressRepositoryTest {

    private ProgressRepository underTest;

    @BeforeEach
    void setUp() {
        underTest = new ProgressRepository();
    }

    @Test
    void create() {
        underTest.create(PROGRESSES_TO_CREATE);
        var progress2 = underTest.create(Progresses.create(BoardId.of(UUID.randomUUID()), List.of(TODO, DONE)));

        then(underTest.getValues()).containsExactlyInAnyOrder(PROGRESSES_TO_CREATE, progress2);
    }

    @Test
    void create_Throws_ForDuplicate() {
        underTest.create(PROGRESSES_TO_CREATE);

        thenExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> underTest.create(PROGRESSES_TO_CREATE))
                .withMessageContaining("progresses with boardId %s already exists".formatted(PROGRESSES_TO_CREATE.getId().getValue()));
    }

    @Test
    void read_IsEmpty() {
        then(underTest.read(PROGRESSES_TO_CREATE.getId())).isEmpty();
    }

    @Test
    void read() {
        var board = underTest.create(PROGRESSES_TO_CREATE);

        then(underTest.read(PROGRESSES_TO_CREATE.getId())).isPresent().contains(board);
    }

}