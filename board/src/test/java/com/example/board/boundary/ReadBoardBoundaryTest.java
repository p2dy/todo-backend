package com.example.board.boundary;


import com.example.board.domain.ReadBoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.NotFoundException;
import java.util.Optional;

import static com.example.board.boundary.BoardDtoFixture.createdBoard;
import static com.example.board.domain.BoardFixture.CREATED_BOARD;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenExceptionOfType;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ReadBoardBoundaryTest {

    @InjectMocks
    ReadBoardBoundary underTest;

    @Mock
    private ReadBoardService service;

    @Test
    void read_ThrowsNotFound() {
        var boardId = CREATED_BOARD.getId().getValue();
        thenExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> underTest.read(boardId))
                .withMessageContaining("can not find board for uniqueId %s".formatted(boardId));
    }

    @Test
    void read_succeeds() {
        given(service.read(CREATED_BOARD.getId())).willReturn(Optional.of(CREATED_BOARD));

        var dto = underTest.read(createdBoard().getUniqueId());

        then(dto).usingRecursiveComparison().isEqualTo(createdBoard());
    }
}