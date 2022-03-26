package com.example.progress.domain;

import com.example.board.domain.Board;
import com.example.board.domain.BoardId;
import com.example.board.events.CreatedBoardEvent;
import com.example.core.domain.Title;

import java.util.UUID;

import static com.example.progress.domain.ProgressColumn.done;
import static com.example.progress.domain.ProgressColumn.todo;
import static com.example.progress.domain.ProgressColumns.defaultColumns;

public class ProgressColumnFixture {
    private static final Title SUPER_TEAM_BOARD_TITLE = Title.of("Super Team Board");
    private static final UUID CREATED_BOARD_ID_VALUE = UUID.fromString("6129aee4-a66e-43bc-8c2a-b30e4a8b0f0a");
    private static final UUID BOARD_TO_CREATE_ID_VALUE = UUID.fromString("0-0-0-0-0");

    private static final Board BOARD_TO_CREATE = Board.create(BoardId.of(BOARD_TO_CREATE_ID_VALUE), SUPER_TEAM_BOARD_TITLE);

    public static final Board CREATED_BOARD = Board.create(BoardId.of(CREATED_BOARD_ID_VALUE), BOARD_TO_CREATE.getTitle());
    public static final CreatedBoardEvent EVENT_OF_CREATED_BOARD = CreatedBoardEvent.of(CREATED_BOARD);
    public static final ProgressColumn TODO_COLUMN = ProgressColumn.todo(ColumnId.defaultId());
    public static final ProgressColumn DONE_COLUMN = ProgressColumn.done(ColumnId.defaultId());
    public static final ProgressColumns DEFAULT_PROGRESS_COLUMNS = defaultColumns(CREATED_BOARD.getId(), TODO_COLUMN, DONE_COLUMN);
}
