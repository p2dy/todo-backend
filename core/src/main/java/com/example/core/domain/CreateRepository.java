package com.example.core.domain;

import com.example.board.domain.BoardId;

import java.util.Collection;
import java.util.Optional;

public interface CreateRepository<T> {
    T create(T model);

    Collection<T> getValues();

    Optional<T> read(BoardId id);
}
