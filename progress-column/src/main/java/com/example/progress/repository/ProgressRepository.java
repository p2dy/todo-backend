package com.example.progress.repository;

import com.example.board.domain.BoardId;
import com.example.core.domain.CreateRepository;
import com.example.progress.domain.Progresses;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ProgressRepository implements CreateRepository<Progresses> {
    private final HashMap<UUID, Progresses> dao = new HashMap<>();

    @Override
    public Progresses create(Progresses progresses) {
        var uuid = progresses.getBoardId().getValue();
        if (!dao.containsKey(uuid)) dao.put(uuid, progresses);
        return dao.get(uuid);
    }

    @Override
    public Collection<Progresses> getValues() {
        return dao.values();
    }

    @Override
    public Optional<Progresses> read(BoardId id) {
        return Optional.empty();
    }
}
