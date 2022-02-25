package com.example.board.domain;

import com.example.core.domain.CreateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.board.domain.BoardFixture.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateBoardServiceTest {

    @InjectMocks
    private CreateBoardService underTest;

    @Mock
    private CreateRepository<Board> repository;

    @Mock
    private BoardIdProvider boardIdProvider;

    @Test
    void create() {
        given(boardIdProvider.generate()).willReturn(BOARD.getId());
        given(repository.create(BOARD)).willReturn(CREATED_BOARD);

        var board = underTest.create(BOARD_TO_CREATE);

        then(board).isEqualTo(CREATED_BOARD);
    }
}