package com.example.core;

import com.example.board.domain.BoardId;

import java.util.List;

public interface ReadByBoardIdRepository<MODEL> {
    List<MODEL> readAllBy(BoardId boardId);
}
