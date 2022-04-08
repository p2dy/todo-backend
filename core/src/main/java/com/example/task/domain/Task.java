package com.example.task.domain;

import com.example.board.domain.BoardId;
import com.example.core.domain.Title;
import com.example.core.domain.WithBoardReference;
import com.example.progress.domain.ProgressId;
import com.example.progress.domain.Progresses;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Task implements WithBoardReference {

    BoardId boardReference;
    ProgressId progressReference;
    TaskId id;
    Title title;

    public boolean references(BoardId boardId) {
        return getBoardReference().equals(boardId);
    }

    @Override
    public BoardId getBoardReference() {
        return boardReference;
    }

    public Task withProgressReference(ProgressId progressReference) {
        return toBuilder().progressReference(progressReference).build();
    }

    public Task withReferenceOnFirstOf(Progresses progresses) {
        var progressReference = progresses.firstProgressReference();
        return withProgressReference(progressReference);
    }
}
