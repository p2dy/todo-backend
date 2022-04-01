package com.example.board.domain;

import com.example.core.CreateRepository;
import com.example.core.events.ObservedCreation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static com.example.core.domain.BoardFixtures.BOARD_TO_CREATE;
import static com.example.core.domain.BoardFixtures.CREATED_BOARD;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CreateBoardServiceTest {

    @InjectMocks
    private CreateBoardService underTest;

    @Mock
    private CreateRepository<Board> createRepository;

    @Test
    void create() {
        given(createRepository.create(BOARD_TO_CREATE)).willReturn(CREATED_BOARD);

        var board = underTest.create(BOARD_TO_CREATE);

        then(board).isEqualTo(CREATED_BOARD);
    }

    @Test
    void create_IsAnnotated() {
        var method = Arrays.stream(CreateBoardService.class.getMethods()).findAny().orElseThrow();
        then(method.getAnnotations()).anyMatch(ObservedCreation.class::isInstance);
    }

}