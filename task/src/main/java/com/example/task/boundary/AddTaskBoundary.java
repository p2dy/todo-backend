package com.example.task.boundary;

import com.example.task.domain.AddIdempotentTask;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@GraphQLApi
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class AddTaskBoundary {

    private final AddIdempotentTask service;

    @Mutation
    public TaskDto addTask(TaskDto taskToAdd) {
        var addedTask = service.add(taskToAdd.model());
        return TaskDto.from(addedTask);
    }
}
