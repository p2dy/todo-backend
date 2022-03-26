package com.example.board.boundary;

import com.example.board.domain.CreateBoardService;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@GraphQLApi
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public final class BoardBoundary {
    private final CreateBoardService createService;

    @Mutation
    public BoardDto createBoard(BoardDto board) {
        return BoardDto.of(createService.create(board.model()));
    }

    @Query
    public BoardDto readBoard() {
        return new BoardDto();
    }

}