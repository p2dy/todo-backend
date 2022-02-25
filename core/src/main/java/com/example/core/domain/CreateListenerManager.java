package com.example.core.domain;

import com.example.board.domain.CreatedListener;

public interface CreateListenerManager<T> {
    void register(CreatedListener<T> listener);
}
