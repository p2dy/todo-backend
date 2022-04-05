package com.example.task.domain;

import com.example.core.CreateRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
class AddBacklogTaskService {
    private final CreateRepository<BacklogTask> repository;

    public BacklogTask add(BacklogTask backlogTask) {
        return repository.create(backlogTask);
    }
}
