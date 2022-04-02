package com.example.progress.domain;

import com.example.core.domain.CreateService;
import com.example.core.CreateRepository;
import com.example.core.events.BoardAware;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
class CreateProgressService implements CreateService<Progresses> {

    private final CreateRepository<Progresses> repository;

    @Override
    public Progresses create(Progresses columnsToCreate) {
        return repository.create(columnsToCreate);
    }

}
