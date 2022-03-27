package com.example.board.domain;

import com.example.core.CreateRepository;
import com.example.core.domain.CreateService;
import com.example.core.events.ObservedCreation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
class CreateBoardService implements CreateService<Board> {

    private final CreateRepository<Board> createRepository;

    @ObservedCreation
    public Board create(Board boardToCreate) {
        return createRepository.create(boardToCreate);
    }

}
