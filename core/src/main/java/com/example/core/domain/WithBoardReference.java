package com.example.core.domain;

import com.example.board.domain.BoardId;

public interface WithBoardReference {
    BoardId getBoardReference();
}
