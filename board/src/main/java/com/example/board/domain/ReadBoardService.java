package com.example.board.domain;

import com.example.core.ReadRepository;
import com.example.core.domain.ReadService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@Slf4j
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class ReadBoardService implements ReadService<BoardId, Board> {

    private final ReadRepository<BoardId, Board> repository;

    public Optional<Board> readBy(BoardId boardId) {
        return repository.read(boardId);
    }

}
