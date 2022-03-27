package com.example.task.domain;

import com.example.core.ReadRepository;
import com.example.core.domain.ReadService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
class ReadTaskService implements ReadService<TaskId, Task> {

    private final ReadRepository<TaskId, Task> repository;

    @Override
    public Optional<Task> read(TaskId taskId) {
        return repository.read(taskId);
    }
}
