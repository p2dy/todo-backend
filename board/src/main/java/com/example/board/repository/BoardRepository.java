package com.example.board.repository;

import com.example.board.domain.Board;
import com.example.board.domain.BoardId;
import com.example.core.domain.Repository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class BoardRepository implements Repository<Board> {
    private final HashMap<UUID, Board> dao = new HashMap<>();

    public Board create(Board board) {
        var uuid = board.getId().getValue();
        if (dao.containsKey(uuid)) {
            throw new IllegalStateException("board with id %s already exists".formatted(uuid));
        }
        dao.put(uuid, board);
        return dao.get(uuid);
    }

    @Override
    public Optional<Board> read(BoardId boardId) {
        return Optional.ofNullable(dao.get(boardId.getValue()));
    }

    @Override
    public Collection<Board> getValues() {
        return dao.values();
    }

}
