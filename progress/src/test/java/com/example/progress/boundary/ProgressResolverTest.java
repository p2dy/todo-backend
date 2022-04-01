package com.example.progress.boundary;

import com.example.board.boundary.BoardDto;
import com.example.board.domain.BoardId;
import com.example.core.domain.ReadService;
import com.example.progress.domain.Progresses;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.NotFoundException;
import java.util.Optional;

import static com.example.core.boundary.BoardDtoFixture.boardToCreate;
import static com.example.core.domain.BoardFixtures.CREATED_BOARD;
import static com.example.core.domain.ProgressFixtures.PROGRESSES_TO_CREATE;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenExceptionOfType;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProgressResolverTest {

    @InjectMocks
    private ProgressResolver underTest;

    @Mock
    private ReadService<BoardId, Progresses> service;

    @Test
    void progresses_ThrowsNotFound() {
        var boardDto = boardToCreate();
        thenExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> underTest.progresses(boardDto))
                .withMessageContaining("can not find progresses for boardId %s".formatted(boardDto.getUniqueId()));
    }

    @Test
    void progresses_succeeds() {
        given(service.read(CREATED_BOARD.getId())).willReturn(Optional.of(PROGRESSES_TO_CREATE));

        var progresses = underTest.progresses(BoardDto.from(CREATED_BOARD));

        then(progresses).usingRecursiveFieldByFieldElementComparator()
                .isEqualTo(ProgressDto.from(PROGRESSES_TO_CREATE));
    }
}