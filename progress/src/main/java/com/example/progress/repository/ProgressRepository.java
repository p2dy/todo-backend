package com.example.progress.repository;

import com.example.board.domain.BoardId;
import com.example.core.CreateRepository;
import com.example.core.ReadRepository;
import com.example.progress.domain.Progresses;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
class ProgressRepository implements CreateRepository<Progresses>, ReadRepository<BoardId, Progresses> {
    private final HashMap<UUID, Progresses> dao = new HashMap<>();

    @Override
    public Progresses create(Progresses progresses) {
        var uuid = progresses.getId().getValue();
        if (dao.containsKey(uuid)) {
            throw new IllegalStateException("progresses with boardId %s already exists".formatted(uuid));
        }
        dao.put(uuid, progresses);
        return dao.get(uuid);
    }

    @Override
    public Optional<Progresses> readBy(BoardId boardId) {
        return Optional.ofNullable(dao.get(boardId.getValue()));
    }

    Collection<Progresses> getValues() {
        return dao.values();
    }
}
