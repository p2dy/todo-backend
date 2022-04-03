package com.example.task.boundary;

import com.example.core.domain.ReadService;
import com.example.progress.boundary.ProgressDto;
import com.example.task.domain.AddIdempotentTask;
import com.example.task.domain.Task;
import com.example.task.domain.TaskId;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@GraphQLApi
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class TaskResolver {

    private final ReadService<TaskId, Task> service;

    @Mutation
    public List<TaskDto> tasks(List<ProgressDto> progressDtos) {
        return Collections.emptyList();
    }
}
