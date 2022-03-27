package com.example.board.events;

import com.example.board.domain.Board;
import com.example.board.domain.BoardId;
import com.example.core.CreatedListener;
import com.example.core.domain.Title;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.enterprise.inject.Instance;
import javax.interceptor.InvocationContext;
import java.util.UUID;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ListenOnCreatedBoardInterceptorTest {

    @InjectMocks
    private ListenOnCreatedBoardInterceptor underTest;

    @Mock
    private Instance<CreatedListener<Board>> mockListeners;

    @Test
    void delegateEvent() throws Exception {
        var invocationContext = mock(InvocationContext.class);
        var board = Board.create(BoardId.of(UUID.randomUUID()), Title.of("Test"));
        given(invocationContext.proceed()).willReturn(board);

        var proceed = underTest.delegateEvent(invocationContext);

        then(proceed).isEqualTo(board);
        verify(mockListeners).forEach(any());
    }
}