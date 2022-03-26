package com.example.progress.domain;

import com.example.board.domain.BoardId;
import lombok.Value;

import java.util.List;

@Value
public class ProgressColumns {

    BoardId boardId;
    List<ProgressColumn> values;

    public static ProgressColumns defaultColumns(BoardId boardId, ProgressColumn todoColumn, ProgressColumn doneColumn) {
        return new ProgressColumns(boardId, List.of(todoColumn, doneColumn));
    }

}
