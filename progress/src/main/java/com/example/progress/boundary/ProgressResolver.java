package com.example.progress.boundary;

import com.example.board.boundary.BoardDto;
import com.example.board.domain.BoardId;
import com.example.core.domain.ReadService;
import com.example.progress.domain.Progresses;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Source;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;

@GraphQLApi
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class ProgressResolver {
    private final ReadService<BoardId, Progresses> service;

    public List<ProgressDto> progresses(@Source BoardDto boardDto) {
        var uniqueId = boardDto.getUniqueId();
        var progresses = service.readBy(BoardId.of(uniqueId))
                .orElseThrow(() -> new NotFoundException("can not find progresses for boardId %s".formatted(uniqueId)));
        return ProgressDto.from(progresses);
    }

}
