package com.example.progress.domain;

import org.junit.jupiter.api.Test;

import static com.example.progress.domain.ProgressColumn.done;
import static com.example.progress.domain.ProgressColumn.todo;
import static com.example.progress.domain.ProgressColumnFixture.*;
import static org.assertj.core.api.BDDAssertions.then;

class ProgressColumnsTest {

    @Test
    void defaultColumns() {
        var progressColumns = ProgressColumns.defaultColumns(CREATED_BOARD.getId(), todo(ColumnId.defaultId()), done(ColumnId.defaultId()));

        then(progressColumns.getValues()).containsExactly(TODO_COLUMN, DONE_COLUMN);
    }
}