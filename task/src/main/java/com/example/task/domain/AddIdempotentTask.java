package com.example.task.domain;

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

    public Task add(Task task) {
        return readService.read(task.getTaskId()).orElseGet(() -> addService.add(task));
    }
}
