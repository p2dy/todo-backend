package com.example.board.domain;

import java.util.UUID;

public class BoardFixture {
    private static final UUID BOARD_TO_CREATE_ID_VALUE = UUID.fromString("0-0-0-0-0");
    private static final UUID BOARD_ID_VALUE = UUID.fromString("e645c7ad-eba7-43f7-ab40-60549502fae5");
    private static final UUID CREATED_BOARD_ID_VALUE = UUID.fromString("6129aee4-a66e-43bc-8c2a-b30e4a8b0f0a");

    public static final Board BOARD_TO_CREATE = Board.create(BOARD_TO_CREATE_ID_VALUE);
    public static final Board BOARD = Board.create(BOARD_ID_VALUE);
    public static final Board CREATED_BOARD = Board.create(CREATED_BOARD_ID_VALUE);
}
