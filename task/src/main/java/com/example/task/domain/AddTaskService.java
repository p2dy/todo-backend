package com.example.task.domain;

import com.example.core.CreateRepository;
import com.example.core.events.ReferencesBoard;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
class AddTaskService {
    private final CreateRepository<Task> repository;

    @ReferencesBoard
    public Task add(Task taskToAdd) {
        return repository.create(taskToAdd);
    }
}
