package com.example.task.domain;

import com.example.board.domain.BoardId;
import com.example.core.CreateRepository;
import com.example.core.domain.ReadService;
import com.example.core.events.ReferencesBoard;
import com.example.progress.domain.Progresses;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
class AddTaskService {
    private final CreateRepository<Task> repository;
    private final ReadService<BoardId, Progresses> readProgressService;

    @ReferencesBoard
    public Task add(Task taskToAdd) {
        if (taskToAdd.getProgressReference().isEmpty()) {
            var progresses = readProgressService.readBy(taskToAdd.getBoardReference()).orElseThrow();
            taskToAdd = taskToAdd.withReferenceOnFirstOf(progresses);
        }
        return repository.create(taskToAdd);
    }

}
