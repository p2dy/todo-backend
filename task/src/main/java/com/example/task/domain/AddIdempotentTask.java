package com.example.task.domain;

import com.example.core.events.ReferencesBoard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class AddIdempotentTask {
    private final ReadTaskService readService;
    private final AddTaskService addService;

    @ReferencesBoard
    public Task add(Task taskToAdd) {
        return readService.readBy(taskToAdd.getId()).orElseGet(() -> addService.add(taskToAdd));
    }
}
