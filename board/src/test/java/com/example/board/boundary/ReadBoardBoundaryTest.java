package com.example.board.boundary;


import com.example.board.domain.ReadBoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

import static com.example.core.boundary.BoardDtoFixture.createdBoard;
import static com.example.core.domain.BoardFixtures.CREATED_BOARD;
import static java.util.Collections.emptyList;
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
    void readBoardBy_ThrowsNotFound() {
        var boardId = CREATED_BOARD.getId().getValue();
        thenExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> underTest.readBoardBy(boardId))
                .withMessageContaining("can not find board for uniqueId %s".formatted(boardId));
    }

    @Test
    void readBoardBy_Succeeds() {
        given(service.readBy(CREATED_BOARD.getId())).willReturn(Optional.of(CREATED_BOARD));

        var dto = underTest.readBoardBy(createdBoard().getUniqueId());

        then(dto).usingRecursiveComparison().isEqualTo(createdBoard());
    }

    @Test
    void readAll_DelegatesToService() {
        given(service.readAll()).willReturn(List.of(CREATED_BOARD));

        var dtos = underTest.readAllBoards();

        then(dtos).containsExactlyInAnyOrder(createdBoard());
    }
}