package com.example.board.events;

import com.example.board.domain.BoardExceptions;
import com.example.board.domain.BoardId;
import com.example.board.domain.ReadBoardService;
import com.example.core.domain.WithBoardId;
import com.example.core.events.BoardAware;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.Arrays;

@Slf4j
@Interceptor
@BoardAware
class ListenOnBoardAwareInterceptor {

    private final ReadBoardService service;

    @Inject
    public ListenOnBoardAwareInterceptor(ReadBoardService service) {
        this.service = service;
    }

    @AroundInvoke
    Object delegateEvent(InvocationContext invocationContext) throws Exception {
        var parameters = invocationContext.getParameters();
        Arrays.stream(parameters)
                .filter(WithBoardId.class::isInstance)
                .map(WithBoardId.class::cast)
                .map(WithBoardId::getBoardId)
                .forEach(this::validateExists);
        return invocationContext.proceed();
    }

    private void validateExists(BoardId boardId) {
        service.readBy(boardId).orElseThrow(BoardExceptions.notFoundFor(boardId));
    }

}

