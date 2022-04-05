package com.example.task.repository;

import com.example.board.domain.BoardId;
import com.example.core.CreateRepository;
import com.example.core.ReadByBoardIdRepository;
import com.example.core.ReadRepository;
import com.example.task.domain.Task;
import com.example.task.domain.TaskId;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class TaskRepository implements CreateRepository<Task>, ReadRepository<TaskId, Task>, ReadByBoardIdRepository<Task> {
    private final HashMap<TaskId, Task> dao = new HashMap<>();

    @Override
    public Task create(Task taskToAdd) {
        var id = taskToAdd.getId();
        if (dao.containsKey(id)) {
            throw new IllegalStateException("task with id %s for boardId %s already exists".formatted(id.getValue(), taskToAdd.getBoardReference().getValue()));
        }
        dao.put(id, taskToAdd);
        return dao.get(id);
    }

    @Override
    public Optional<Task> readBy(TaskId taskId) {
        return Optional.ofNullable(dao.get(taskId));
    }

    @Override
    public List<Task> readAllBy(BoardId boardId) {
        return dao.values().stream().filter(task -> task.references(boardId)).toList();
    }

    Collection<Task> values() {
        return dao.values();
    }
}
