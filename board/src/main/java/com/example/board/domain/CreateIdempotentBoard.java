package com.example.board.domain;

import com.example.core.domain.CreateService;
import com.example.core.domain.ReadService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class CreateIdempotentBoard {
    private final ReadService<BoardId, Board> readService;
    private final CreateService<Board> createService;

    public Board create(Board model) {
        return readService.read(model.getId()).orElseGet(() -> createService.create(model));
    }
}
