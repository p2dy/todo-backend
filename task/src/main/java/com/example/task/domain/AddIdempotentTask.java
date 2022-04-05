package com.example.task.domain;

import com.example.core.events.BoardAware;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class AddIdempotentTask {
    private final ReadBacklogTaskService readService;
    private final AddBacklogTaskService addService;

    @BoardAware
    public BacklogTask add(BacklogTask backlogTask) {
        return readService.readBy(backlogTask.getId()).orElseGet(() -> addService.add(backlogTask));
    }

}
