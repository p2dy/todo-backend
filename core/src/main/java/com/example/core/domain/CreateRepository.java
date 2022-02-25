package com.example.core.domain;

public interface CreateRepository<T> {
    T create(T model);
}
