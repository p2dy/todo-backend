package com.example.progress.listener;

import com.example.board.events.CreatedBoardEvent;
import com.example.progress.domain.ColumnId;
import com.example.progress.domain.CreateProgressColumnService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import static com.example.progress.domain.ProgressColumn.done;
import static com.example.progress.domain.ProgressColumn.todo;
import static com.example.progress.domain.ProgressColumns.defaultColumns;

@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
@Slf4j
public class CreateBoardObserver {

    private final CreateProgressColumnService service;

    public void on(@Observes CreatedBoardEvent board) {
        service.create(defaultColumns(board.getId(), todo(ColumnId.defaultId()), done(ColumnId.defaultId())));
    }

}
