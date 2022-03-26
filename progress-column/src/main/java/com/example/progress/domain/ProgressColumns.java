package com.example.progress.domain;

import com.example.board.domain.BoardId;
import lombok.Value;

import java.util.List;

@Value
public class ProgressColumns {

    BoardId boardId;
    List<ProgressColumn> values;

    public static ProgressColumns create(BoardId boardId, List<ProgressColumn> values) {
        return new ProgressColumns(boardId, values);
    }

}
