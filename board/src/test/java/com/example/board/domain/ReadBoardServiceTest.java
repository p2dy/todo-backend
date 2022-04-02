package com.example.board.domain;

import com.example.core.ReadRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.example.core.domain.BoardFixtures.CREATED_BOARD;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ReadBoardServiceTest {

    @InjectMocks
    private ReadBoardService underTest;

    @Mock
    private ReadAllRepository<BoardId, Board> repository;

    @Test
    void readBy_ReturnsEmpty() {
        then(underTest.readBy(CREATED_BOARD.getId())).isEmpty();
    }

    @Test
    void readBy_ReturnsModel() {
        var boardId = CREATED_BOARD.getId();
        given(repository.readBy(boardId)).willReturn(Optional.of(CREATED_BOARD));

        then(underTest.readBy(boardId)).contains(CREATED_BOARD);
    }

    @Test
    void readAll_ReturnsModel() {
        given(repository.readAll()).willReturn(List.of(CREATED_BOARD));

        then(underTest.readAll()).contains(CREATED_BOARD);
    }
}