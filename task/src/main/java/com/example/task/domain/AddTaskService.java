package com.example.task.domain;

import com.example.core.CreateRepository;
import com.example.core.events.BoardAware;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
class AddTaskService {
    private final CreateRepository<Task> repository;

    @BoardAware
    public Task add(Task task) {
        return repository.create(task);
    }
}
