package com.example.core.domain;

import com.example.board.domain.BoardId;

import java.util.Collection;
import java.util.Optional;

public interface Repository<T> {
    T create(T model);

    Optional<T> read(BoardId id);

    Collection<T> getValues();
}
