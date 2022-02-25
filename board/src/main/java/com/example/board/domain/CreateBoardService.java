package com.example.board.domain;

import com.example.core.domain.CreateRepository;
import lombok.AllArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class CreateBoardService {

    private final CreateRepository<Board> repository;
    private final BoardIdProvider idProvider;

    public Board create(Board boardToCreate) {
        var boardId = idProvider.generate();
        var board = boardToCreate.with(boardId);
        return repository.create(board);
    }
}
