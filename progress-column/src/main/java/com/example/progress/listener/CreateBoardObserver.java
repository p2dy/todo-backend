package com.example.progress.listener;

import com.example.board.events.CreatedBoardEvent;
import com.example.progress.domain.ProgressIdProvider;
import com.example.progress.domain.CreateProgressService;
import com.example.progress.domain.Progresses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.List;

import static com.example.progress.domain.Progress.done;
import static com.example.progress.domain.Progress.todo;

@Slf4j
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class CreateBoardObserver {

    private final CreateProgressService service;
    private final ProgressIdProvider progressIdProvider;

    public void on(@Observes CreatedBoardEvent board) {
        var todoColumn = todo(progressIdProvider.generate());
        var doneColumn = done(progressIdProvider.generate());
        service.create(Progresses.create(board.getId(), List.of(todoColumn, doneColumn)));
    }

}

