package com.example.progress.listener;

import com.example.board.domain.Board;
import com.example.board.domain.BoardId;
import com.example.board.domain.Title;
import com.example.board.events.BoardCreateEvent;
import com.example.progress.domain.CreateProgressColumnService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateBoardObserverTest {
    public static final Title SUPER_TEAM_BOARD_TITLE = Title.of("Super Team Board");
    private static final UUID BOARD_TO_CREATE_ID_VALUE = UUID.fromString("0-0-0-0-0");
    private static final UUID CREATED_BOARD_ID_VALUE = UUID.fromString("6129aee4-a66e-43bc-8c2a-b30e4a8b0f0a");

    public static final Board BOARD_TO_CREATE = Board.create(BoardId.of(BOARD_TO_CREATE_ID_VALUE), SUPER_TEAM_BOARD_TITLE);
    public static final Board CREATED_BOARD = Board.create(BoardId.of(CREATED_BOARD_ID_VALUE), BOARD_TO_CREATE.getTitle());
    public static final BoardCreateEvent EVENT_OF_CREATED_BOARD = BoardCreateEvent.eventOf(CREATED_BOARD);

    @InjectMocks
    CreateBoardObserver observer;

    @Mock
    private CreateProgressColumnService service;

    @Test
    void onBoardCreate_delegatesToService() {
      observer.on(EVENT_OF_CREATED_BOARD);

      verify(service).createDefaultFor(EVENT_OF_CREATED_BOARD.getBoard());
    }
}