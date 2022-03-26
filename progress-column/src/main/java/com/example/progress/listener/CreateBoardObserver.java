package com.example.progress.listener;

import com.example.board.events.CreatedBoardEvent;
import com.example.core.domain.UniqueIdProvider;
import com.example.progress.domain.ColumnId;
import com.example.progress.domain.CreateProgressColumnService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import java.util.List;

import static com.example.progress.domain.ProgressColumn.done;
import static com.example.progress.domain.ProgressColumn.todo;
import static com.example.progress.domain.ProgressColumns.create;

@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
@Slf4j
public class CreateBoardObserver {

    private final CreateProgressColumnService service;
    private final UniqueIdProvider uniqueIdProvider;

    public void on(@Observes CreatedBoardEvent board) {
        var todoColumn = todo(ColumnId.of(uniqueIdProvider.generate()));
        var doneColumn = done(ColumnId.of(uniqueIdProvider.generate()));
        var columnsToCreate = create(board.getId(), List.of(todoColumn, doneColumn));
        service.create(columnsToCreate);
    }

}
