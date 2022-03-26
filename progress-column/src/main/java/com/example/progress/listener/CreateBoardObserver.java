package com.example.progress.listener;

import com.example.board.events.BoardCreateEvent;
import com.example.progress.domain.CreateProgressColumnService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
@Slf4j
public class CreateBoardObserver {

    private final CreateProgressColumnService service;

    public void on(@Observes BoardCreateEvent event) {
        service.createDefaultFor(event.getBoard());
    }
}
