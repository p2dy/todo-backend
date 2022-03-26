package com.example.board.domain;

import com.example.board.events.BoardCreateEvent;

import java.util.UUID;

public class BoardFixture {
    public static final Title SUPER_TEAM_BOARD_TITLE = Title.of("Super Team Board");
    private static final UUID BOARD_TO_CREATE_ID_VALUE = UUID.fromString("0-0-0-0-0");
    private static final UUID BOARD_ID_VALUE = UUID.fromString("e645c7ad-eba7-43f7-ab40-60549502fae5");
    private static final UUID CREATED_BOARD_ID_VALUE = UUID.fromString("6129aee4-a66e-43bc-8c2a-b30e4a8b0f0a");

    public static final Board BOARD_TO_CREATE = Board.create(BoardId.of(BOARD_TO_CREATE_ID_VALUE), SUPER_TEAM_BOARD_TITLE);
    public static final Board CREATED_BOARD = Board.create(BoardId.of(CREATED_BOARD_ID_VALUE), BOARD_TO_CREATE.getTitle());
    public static final Board BOARD = Board.create(BoardId.of(BOARD_ID_VALUE), SUPER_TEAM_BOARD_TITLE);
    public static final BoardCreateEvent EVENT_OF_CREATED_BOARD = BoardCreateEvent.eventOf(CREATED_BOARD);
}
