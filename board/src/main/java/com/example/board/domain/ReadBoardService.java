package com.example.board.domain;

import com.example.board.ReadBoardRepository;
import com.example.core.domain.ReadService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Slf4j
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class ReadBoardService implements ReadService<BoardId, Board> {

    private final ReadBoardRepository<BoardId, Board> repository;

    public Optional<Board> readBy(BoardId boardId) {
        return repository.readBy(boardId);
    }

    public List<Board> readAll() {
        return repository.readAll();
    }
}
