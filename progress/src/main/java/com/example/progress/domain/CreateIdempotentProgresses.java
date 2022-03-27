package com.example.progress.domain;

import com.example.board.domain.BoardId;
import com.example.core.domain.CreateService;
import com.example.core.domain.ReadService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class CreateIdempotentProgresses {
    private final ReadService<BoardId, Progresses> readService;
    private final CreateService<Progresses> createService;

    public Progresses create(Progresses model) {
        return readService.read(model.getId()).orElseGet(() -> createService.create(model));
    }
}
