package com.example.board.domain;

public interface CreatedListener<T> {
    void informOn(T identifier);
}
