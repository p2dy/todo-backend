package com.example.board.domain;

import com.example.board.events.CreatedBoardEvent;
import com.example.core.domain.Title;

import java.util.UUID;

public class BoardFixture {
    private static final Title SUPER_TEAM_BOARD_TITLE = Title.of("Super Team Board");
    private static final UUID BOARD_TO_CREATE_ID_VALUE = UUID.fromString("24e9a45b-3ad1-4b70-b6e6-e36a1a4232bc");
    private static final UUID CREATED_BOARD_ID_VALUE = UUID.fromString("6129aee4-a66e-43bc-8c2a-b30e4a8b0f0a");

    public static final Board BOARD_TO_CREATE = Board.create(BoardId.of(BOARD_TO_CREATE_ID_VALUE), SUPER_TEAM_BOARD_TITLE);
    public static final Board CREATED_BOARD = Board.create(BoardId.of(CREATED_BOARD_ID_VALUE), BOARD_TO_CREATE.getTitle());
    public static final CreatedBoardEvent EVENT_OF_CREATED_BOARD = CreatedBoardEvent.of(CREATED_BOARD);
}
