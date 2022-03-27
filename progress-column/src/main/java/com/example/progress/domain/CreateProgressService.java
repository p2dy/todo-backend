package com.example.progress.domain;

import com.example.core.domain.CreateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CreateProgressService {

    private final CreateRepository<Progresses> repository;

    public void create(Progresses columnsToCreate) {
        repository.create(columnsToCreate);
    }
}
