package com.example.progress.domain;

import com.example.core.domain.Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CreateProgressService {

    private final Repository<Progresses> repository;

    public void create(Progresses columnsToCreate) {
        repository.create(columnsToCreate);
    }
}
