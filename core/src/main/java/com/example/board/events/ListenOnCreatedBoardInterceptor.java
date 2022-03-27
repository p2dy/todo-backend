package com.example.board.events;

import com.example.board.domain.Board;
import com.example.core.CreatedListener;
import com.example.core.events.ObservedCreation;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Slf4j
@Interceptor
@ObservedCreation
public class ListenOnCreatedBoardInterceptor {

    private final Instance<CreatedListener<Board>> delegates;

    @Inject
    public ListenOnCreatedBoardInterceptor(@Any Instance<CreatedListener<Board>> delegates) {
        this.delegates = delegates;
    }

    @AroundInvoke
    Object delegateEvent(InvocationContext invocationContext) throws Exception {
        var proceed = invocationContext.proceed();
        if (proceed instanceof Board) {
            delegates.forEach(listener ->  listener.onCreated((Board) proceed));
        }
        return proceed;
    }
}

