package com.example.board.domain;

import com.example.board.events.CreatedBoardEvent;
import com.example.core.domain.CreateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import static com.example.board.events.CreatedBoardEvent.of;

@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
@Slf4j
public class CreateBoardService {

    private final CreateRepository<Board> repository;
    private final BoardIdProvider idProvider;
    private final Event<CreatedBoardEvent> event;

    public Board create(Board boardToCreate) {
        var boardId = idProvider.generate();
        var board = boardToCreate.with(boardId);
        var createdBoard = repository.create(board);
        event.fire(of(createdBoard));
        return createdBoard;
    }
}
