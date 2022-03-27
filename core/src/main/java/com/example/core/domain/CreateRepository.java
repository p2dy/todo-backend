package com.example.core.domain;

import java.util.Collection;

public interface CreateRepository<T> {
    T create(T model);

    Collection<T> getValues();
}
