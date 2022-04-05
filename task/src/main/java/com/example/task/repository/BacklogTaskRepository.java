package com.example.task.repository;

import com.example.board.domain.BoardId;
import com.example.core.CreateRepository;
import com.example.core.ReadByBoardIdRepository;
import com.example.core.ReadRepository;
import com.example.task.domain.BacklogTask;
import com.example.task.domain.BacklogTaskId;
import com.example.task.domain.Task;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BacklogTaskRepository implements CreateRepository<BacklogTask>, ReadRepository<BacklogTaskId, BacklogTask>, ReadByBoardIdRepository<BacklogTask> {
    private final HashMap<BacklogTaskId, Task> dao = new HashMap<>();

    @Override
    public BacklogTask create(BacklogTask backlogTask) {
        var id = backlogTask.getId();
        if (dao.containsKey(id)) {
            throw new IllegalStateException("task with id %s for boardId %s already exists".formatted(id.getTaskIdValue(), id.getBoardIdValue()));
        }
        dao.put(id, backlogTask.getTask());
        return BacklogTask.create(id.getBoardId(), dao.get(id));
    }

    @Override
    public Optional<BacklogTask> readBy(BacklogTaskId backlogTaskId) {
        var task = Optional.ofNullable(dao.get(backlogTaskId));
        return task.map(it -> BacklogTask.create(backlogTaskId.getBoardId(), it));
    }

    @Override
    public List<BacklogTask> readAllBy(BoardId boardId) {
        var backlogTaskIds = dao.keySet().stream().filter(id -> id.getBoardId().equals(boardId)).toList();
        return backlogTaskIds.stream().map(id -> BacklogTask.create(id.getBoardId(), dao.get(id))).toList();
    }

    Collection<Task> values() {
        return dao.values();
    }
}
