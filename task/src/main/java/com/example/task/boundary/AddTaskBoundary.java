package com.example.task.boundary;

import com.example.task.domain.AddIdempotentTask;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@GraphQLApi
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class AddTaskBoundary {

    private final AddIdempotentTask service;

    @Mutation
    public TaskDto add(TaskDto task, UUID boardId) {
        return TaskDto.from(service.add(task.model(boardId)));
    }
}
