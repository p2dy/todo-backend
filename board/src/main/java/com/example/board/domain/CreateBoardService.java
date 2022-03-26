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
    private final Event<CreatedBoardEvent> event;

    public Board create(Board boardToCreate) {
        var createdBoard = repository.create(boardToCreate);
        event.fire(of(createdBoard));
        return createdBoard;
    }
}
