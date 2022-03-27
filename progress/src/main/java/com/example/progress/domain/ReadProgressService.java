package com.example.progress.domain;

import com.example.board.domain.BoardId;
import com.example.core.ReadRepository;
import com.example.core.domain.ReadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
class ReadProgressService implements ReadService<BoardId, Progresses> {

    private final ReadRepository<BoardId, Progresses> repository;

    @Override
    public Optional<Progresses> read(BoardId boardId) {
        return repository.read(boardId);
    }
}
