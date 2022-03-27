package com.example.progress.repository;

import com.example.board.domain.BoardId;
import com.example.progress.domain.Progresses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static com.example.progress.domain.ProgressColumnFixture.*;
import static java.util.Collections.*;
import static org.assertj.core.api.BDDAssertions.then;

class ProgressRepositoryTest {

    private ProgressRepository underTest;

    @BeforeEach
    void setUp() {
        underTest = new ProgressRepository();
    }

    @Test
    void create() {
        underTest.create(PROGRESS_COLUMNS_TO_CREATE);
        var progress2 = underTest.create(Progresses.create(BoardId.of(UUID.randomUUID()), List.of(TODO_COLUMN, DONE_COLUMN)));

        then(underTest.getValues()).containsExactlyInAnyOrder(PROGRESS_COLUMNS_TO_CREATE, progress2);
    }

    @Test
    void create_Idempotent() {
        underTest.create(PROGRESS_COLUMNS_TO_CREATE);
        var withSameBoardId = Progresses.create(PROGRESS_COLUMNS_TO_CREATE.getBoardId(), emptyList());
        underTest.create(withSameBoardId);

        then(underTest.getValues()).containsExactly(PROGRESS_COLUMNS_TO_CREATE);
    }

}