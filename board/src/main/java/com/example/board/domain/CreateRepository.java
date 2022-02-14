package com.example.board.domain;

public interface CreateRepository<T> {
    T create(T model);
}
