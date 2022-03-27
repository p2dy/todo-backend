package com.example.board.boundary;

import com.example.board.domain.Board;
import com.example.board.domain.BoardId;
import com.example.core.domain.IdempotentService;
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
    private final IdempotentService<BoardId, Board> service;

    @Mutation
    public BoardDto createBoard(BoardDto board) {
        return BoardDto.of(service.createIdempotent(board.model()));
    }

    @Query
    public BoardDto readBoard() {
        return new BoardDto();
    }

}