package com.example.progress.listener;

import com.example.board.domain.Board;
import com.example.core.CreatedListener;
import com.example.progress.domain.CreateIdempotentProgresses;
import com.example.progress.domain.ProgressIdProvider;
import com.example.progress.domain.Progresses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

import static com.example.progress.domain.Progress.done;
import static com.example.progress.domain.Progress.todo;

@Slf4j
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class CreateDefaultProgressesForBoard implements CreatedListener<Board> {

    private final CreateIdempotentProgresses service;
    private final ProgressIdProvider progressIdProvider;

    @Override
    public void onCreated(Board board) {
        var todo = todo(progressIdProvider.generate());
        var done = done(progressIdProvider.generate());
        service.create(Progresses.create(board.getId(), List.of(todo, done)));
    }
}

