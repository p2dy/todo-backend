package com.example.board.repository;

import com.example.board.domain.Board;
import com.example.core.domain.CreateRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@ApplicationScoped
public class BoardRepository implements CreateRepository<Board> {
    private final HashMap<UUID, Board> dao = new HashMap<>();

    public Board create(Board board) {
        var uuid = board.getId().getValue();
        if(!dao.containsKey(uuid)) dao.put(uuid, board);
        return dao.get(uuid);
    }

    @Override
    public Collection<Board> getValues() {
        return dao.values();
    }

}
