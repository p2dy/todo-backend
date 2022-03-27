package com.example.progress.domain;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;


@Slf4j
@ApplicationScoped
@AllArgsConstructor(onConstructor_ = @Inject)
public class ProgressIdProvider {

    public ProgressId generate() {
        return ProgressId.of(UUID.randomUUID());
    }
}
