package com.example.task.boundary;

import com.example.board.domain.BoardId;
import com.example.task.domain.AddIdempotentTask;
import com.example.task.domain.BacklogTask;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@GraphQLApi
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class AddTaskToBacklogBoundary {

    private final AddIdempotentTask service;

    @Mutation
    public TaskDto addTask(TaskDto task, UUID boardId) {
        var addedTask = service.add(BacklogTask.create(BoardId.of(boardId), task.model()));
        return TaskDto.from(addedTask);
    }
}
