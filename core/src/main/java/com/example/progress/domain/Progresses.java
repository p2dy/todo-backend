package com.example.progress.domain;

import com.example.board.domain.BoardId;
import com.example.core.domain.WithId;
import lombok.Value;

import java.util.List;

@Value
public class Progresses implements WithId<BoardId> {

    BoardId id;
    List<Progress> values;

    public static Progresses create(BoardId boardId, List<Progress> values) {
        return new Progresses(boardId, values);
    }

}