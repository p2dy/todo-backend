package com.example.task.boundary;

import com.example.board.boundary.BoardDto;
import com.example.board.domain.BoardId;
import com.example.task.domain.ReadTaskService;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Source;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@GraphQLApi
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class TaskResolver {

    private final ReadTaskService service;

    @Mutation
    public List<TaskDto> tasks(@Source BoardDto board) {
        var boardId = BoardId.of(board.getUniqueId());
        return service.readAllBy(boardId).stream().map(TaskDto::from).toList();
    }

}
