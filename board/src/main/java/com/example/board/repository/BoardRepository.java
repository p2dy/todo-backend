package com.example.board.repository;

import com.example.board.domain.Board;
import com.example.board.domain.BoardId;
import com.example.board.domain.ReadAllRepository;
import com.example.core.CreateRepository;
import com.example.core.ReadRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
class BoardRepository implements CreateRepository<Board>, ReadAllRepository<BoardId, Board> {
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
    public Optional<Board> readBy(BoardId boardId) {
        return Optional.ofNullable(dao.get(boardId.getValue()));
    }

    @Override
    public List<Board> readAll() {
        return dao.values().stream().toList();
    }

}
