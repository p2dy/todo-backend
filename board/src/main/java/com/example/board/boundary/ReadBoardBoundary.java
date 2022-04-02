package com.example.board.boundary;

import com.example.board.domain.BoardExceptions;
import com.example.board.domain.BoardId;
import com.example.board.domain.ReadBoardService;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@GraphQLApi
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public final class ReadBoardBoundary {

    private final ReadBoardService service;

    @Query
    public BoardDto readBoardBy(UUID boardId) {
        var id = BoardId.of(boardId);
        return service.readBy(id).map(BoardDto::from).orElseThrow(BoardExceptions.notFoundFor(id));
    }

    @Query
    public List<BoardDto> readAllBoards() {
        return service.readAll().stream().map(BoardDto::from).toList();
    }
}