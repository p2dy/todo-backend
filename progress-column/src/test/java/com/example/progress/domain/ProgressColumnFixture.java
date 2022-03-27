package com.example.progress.domain;

import com.example.board.domain.Board;
import com.example.board.domain.BoardId;
import com.example.board.events.CreatedBoardEvent;
import com.example.core.domain.Title;

import java.util.List;
import java.util.UUID;

public class ProgressColumnFixture {
    private static final Title SUPER_TEAM_BOARD_TITLE = Title.of("Super Team Board");
    private static final UUID CREATED_BOARD_ID_VALUE = UUID.fromString("6129aee4-a66e-43bc-8c2a-b30e4a8b0f0a");
    private static final UUID BOARD_TO_CREATE_ID_VALUE = UUID.fromString("0-0-0-0-0");
    private static final Board BOARD_TO_CREATE = Board.create(BoardId.of(BOARD_TO_CREATE_ID_VALUE), SUPER_TEAM_BOARD_TITLE);

    public static final Board CREATED_BOARD = Board.create(BoardId.of(CREATED_BOARD_ID_VALUE), BOARD_TO_CREATE.getTitle());
    public static final CreatedBoardEvent EVENT_OF_CREATED_BOARD = CreatedBoardEvent.of(CREATED_BOARD);



    public static final ProgressId TODO_COLUMN_ID = ProgressId.of(UUID.fromString("d72a66fc-95b7-4567-9ec0-a7a2696fd6ab"));
    public static final ProgressId DONE_COLUMN_ID = ProgressId.of(UUID.fromString("8221edb6-14b8-410c-b175-d89eeae52c68"));
    public static final Progress TODO_COLUMN = Progress.todo(TODO_COLUMN_ID);
    public static final Progress DONE_COLUMN = Progress.done(DONE_COLUMN_ID);
    public static final Progresses DEFAULT_PROGRESS_COLUMNS =
            Progresses.create(CREATED_BOARD.getId(), List.of(TODO_COLUMN, DONE_COLUMN));

    private static final ProgressId IN_PROGRESS_COLUMN_ID = ProgressId.of(UUID.fromString("43a2d592-61b0-41b0-92e6-0da9e37dd0a9"));
    private static final Title IN_PROGRESS_TITLE = Title.of("In progress");
    private static final ProgressId IN_REVIEW_COLUMN_ID = ProgressId.of(UUID.fromString("2058c0ae-0de9-471c-8c40-bba52268a9a5"));
    private static final Title IN_REVIEW_TITLE = Title.of("In review");
    public static final Progress IN_PROGRESS_CONDITION_COLUMN = Progress.create(IN_PROGRESS_COLUMN_ID, IN_PROGRESS_TITLE);
    public static final Progress IN_REVIEW_COLUMN = Progress.create(IN_REVIEW_COLUMN_ID, IN_REVIEW_TITLE);
    public static final Progresses PROGRESS_COLUMNS_TO_CREATE =
            Progresses.create(CREATED_BOARD.getId(), List.of(IN_PROGRESS_CONDITION_COLUMN, IN_REVIEW_COLUMN));
}
