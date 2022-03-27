package com.example.board.boundary;

import com.example.board.domain.CreateIdempotentBoard;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@GraphQLApi
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public final class CreateBoardBoundary {
    private final CreateIdempotentBoard service;

    @Mutation
    public BoardDto create(BoardDto board) {
        return BoardDto.from(service.create(board.toModel()));
    }

}