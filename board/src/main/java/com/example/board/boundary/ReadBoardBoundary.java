package com.example.board.boundary;

import com.example.board.domain.BoardId;
import com.example.board.domain.ReadBoardService;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.UUID;

@GraphQLApi
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public final class ReadBoardBoundary {

    private final ReadBoardService service;

    @Query
    public BoardDto read(UUID boardId) {
        return service.read(BoardId.of(boardId)).map(BoardDto::from)
                .orElseThrow(() -> new NotFoundException("can not find board for uniqueId %s".formatted(boardId)));
    }

}