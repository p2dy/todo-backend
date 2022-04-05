package com.example.task.domain;

import com.example.board.domain.BoardId;
import com.example.core.ReadByBoardIdRepository;
import com.example.core.ReadRepository;
import com.example.core.domain.ReadService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ReadTaskService implements ReadService<TaskId, Task> {

    private final ReadRepository<TaskId, Task> repository;
    private final ReadByBoardIdRepository<Task> byBoardIdRepository;


    public Optional<Task> readBy(TaskId taskId) {
        return repository.readBy(taskId);
    }

    public List<Task> readAllBy(BoardId boardId) {
        return byBoardIdRepository.readAllBy(boardId);
    }
}
