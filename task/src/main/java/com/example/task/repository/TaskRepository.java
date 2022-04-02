package com.example.task.repository;

import com.example.core.CreateRepository;
import com.example.core.ReadRepository;
import com.example.task.domain.Task;
import com.example.task.domain.TaskId;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class TaskRepository implements CreateRepository<Task>, ReadRepository<TaskId, Task> {
    private final HashMap<TaskId, Task> dao = new HashMap<>();

    @Override
    public Task create(Task task) {
        var id = task.getTaskId();
        if (dao.containsKey(id)) {
            throw new IllegalStateException("task with id %s for boardId %s already exists".formatted(id.getValue(), id.getBoardId()));
        }
        dao.put(id, task);
        return dao.get(id);
    }

    @Override
    public Optional<Task> readBy(TaskId taskId) {
        return Optional.ofNullable(dao.get(taskId));
    }
}
