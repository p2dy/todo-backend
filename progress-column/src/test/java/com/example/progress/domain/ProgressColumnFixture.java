package com.example.progress.domain;

import com.example.board.domain.Board;
import com.example.board.domain.BoardId;
import com.example.board.events.CreatedBoardEvent;
import com.example.core.domain.Title;

import java.util.List;
import java.util.UUID;

import static com.example.progress.domain.ProgressColumns.create;

public class ProgressColumnFixture {
    private static final Title SUPER_TEAM_BOARD_TITLE = Title.of("Super Team Board");
    private static final UUID CREATED_BOARD_ID_VALUE = UUID.fromString("6129aee4-a66e-43bc-8c2a-b30e4a8b0f0a");
    private static final UUID BOARD_TO_CREATE_ID_VALUE = UUID.fromString("0-0-0-0-0");

    private static final Board BOARD_TO_CREATE = Board.create(BoardId.of(BOARD_TO_CREATE_ID_VALUE), SUPER_TEAM_BOARD_TITLE);

    public static final Board CREATED_BOARD = Board.create(BoardId.of(CREATED_BOARD_ID_VALUE), BOARD_TO_CREATE.getTitle());
    public static final CreatedBoardEvent EVENT_OF_CREATED_BOARD = CreatedBoardEvent.of(CREATED_BOARD);



    public static final ColumnId TODO_COLUMN_ID = ColumnId.of(UUID.fromString("d72a66fc-95b7-4567-9ec0-a7a2696fd6ab"));
    public static final ColumnId DONE_COLUMN_ID = ColumnId.of(UUID.fromString("8221edb6-14b8-410c-b175-d89eeae52c68"));
    public static final ProgressColumn TODO_COLUMN = ProgressColumn.todo(TODO_COLUMN_ID);
    public static final ProgressColumn DONE_COLUMN = ProgressColumn.done(DONE_COLUMN_ID);
    public static final ProgressColumns DEFAULT_PROGRESS_COLUMNS = create(CREATED_BOARD.getId(), List.of(TODO_COLUMN, DONE_COLUMN));
}
