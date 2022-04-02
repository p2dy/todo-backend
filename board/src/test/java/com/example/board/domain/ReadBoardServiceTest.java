package com.example.board.domain;

import com.example.core.ReadRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.core.domain.BoardFixtures.CREATED_BOARD;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ReadBoardServiceTest {

    @InjectMocks
    private ReadBoardService underTest;

    @Mock
    private ReadRepository<BoardId, Board> repository;

    @Test
    void read_ReturnsEmpty() {
        then(underTest.readBy(CREATED_BOARD.getId())).isEmpty();
    }

    @Test
    void read_ReturnsModel() {
        var boardId = CREATED_BOARD.getId();
        given(repository.read(boardId)).willReturn(Optional.of(CREATED_BOARD));

        then(underTest.readBy(boardId)).contains(CREATED_BOARD);
    }
}