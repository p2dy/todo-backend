package com.example.progress.domain;

import com.example.board.domain.BoardId;
import com.example.core.ReadRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.progress.domain.ProgressFixture.PROGRESSES_TO_CREATE;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ReadProgressServiceTest {

    @InjectMocks
    private ReadProgressService underTest;

    @Mock
    private ReadRepository<BoardId, Progresses> repository;

    @Test
    void read_IsEmpty() {
        then(underTest.read(PROGRESSES_TO_CREATE.getId())).isEmpty();
    }

    @Test
    void read() {
        given(repository.read(PROGRESSES_TO_CREATE.getId())).willReturn(Optional.of(PROGRESSES_TO_CREATE));

        then(underTest.read(PROGRESSES_TO_CREATE.getId())).contains(PROGRESSES_TO_CREATE);
    }

}