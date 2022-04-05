package com.example.task.domain;

import com.example.board.domain.BoardId;
import com.example.core.ReadByBoardIdRepository;
import com.example.core.ReadRepository;
import com.example.core.domain.ReadService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ReadBacklogTaskService implements ReadService<BacklogTaskId, BacklogTask> {

    private final ReadRepository<BacklogTaskId, BacklogTask> repository;
    private final ReadByBoardIdRepository<BacklogTask> byBoardIdRepository;

    @Override
    public Optional<BacklogTask> readBy(BacklogTaskId backlogTaskId) {
        return repository.readBy(backlogTaskId);
    }

    public List<BacklogTask> readAllBy(BoardId boardId) {
        return byBoardIdRepository.readAllBy(boardId);
    }
}
