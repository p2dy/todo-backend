package com.example.core.domain;

import com.example.progress.boundary.ProgressDto;
import com.example.progress.domain.Progress;
import com.example.progress.domain.ProgressId;
import com.example.progress.domain.Progresses;

import java.util.List;
import java.util.UUID;

import static com.example.core.domain.BoardFixtures.CREATED_BOARD;

public class ProgressFixtures {
    public static final ProgressId TODO_ID = ProgressId.of(UUID.fromString("d72a66fc-95b7-4567-9ec0-a7a2696fd6ab"));
    public static final ProgressId DONE_ID = ProgressId.of(UUID.fromString("8221edb6-14b8-410c-b175-d89eeae52c68"));
    public static final Progress TODO = Progress.todo(TODO_ID);
    public static final Progress DONE = Progress.done(DONE_ID);
    public static final Progresses DEFAULT_PROGRESSES = Progresses.create(CREATED_BOARD.getId(), List.of(TODO, DONE));

    private static final ProgressId IN_PROGRESS_ID = ProgressId.of(UUID.fromString("43a2d592-61b0-41b0-92e6-0da9e37dd0a9"));
    private static final Title IN_PROGRESS_TITLE = Title.of("In progress");
    private static final ProgressId IN_REVIEW_ID = ProgressId.of(UUID.fromString("2058c0ae-0de9-471c-8c40-bba52268a9a5"));
    private static final Title IN_REVIEW_TITLE = Title.of("In review");
    public static final Progress IN_PROGRESS = Progress.create(IN_PROGRESS_ID, IN_PROGRESS_TITLE, 0);
    public static final Progress IN_REVIEW = Progress.create(IN_REVIEW_ID, IN_REVIEW_TITLE, 1);
    public static final Progresses PROGRESSES_TO_CREATE = Progresses.create(CREATED_BOARD.getId(), List.of(IN_PROGRESS, IN_REVIEW));

    public static List<ProgressDto> progressesToCreate() {
        return ProgressDto.from(PROGRESSES_TO_CREATE);
    }
}
