package com.example.board.domain;

import com.example.board.events.CreatedBoardEvent;
import com.example.core.domain.Repository;
import com.example.core.domain.IdempotentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import java.util.Optional;

import static com.example.board.events.CreatedBoardEvent.of;

@Slf4j
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class BoardService extends IdempotentService<BoardId, Board> {

    private final Repository<Board> repository;
    private final Event<CreatedBoardEvent> event;

    public Board create(Board boardToCreate) {
        var createdBoard = repository.create(boardToCreate);
        event.fire(of(createdBoard));
        return createdBoard;
    }

    public Optional<Board> read(BoardId boardId) {
        return repository.read(boardId);
    }

}
