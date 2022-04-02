package com.example.board.domain;

import com.example.core.ReadRepository;

import java.util.List;

public interface ReadAllRepository<MODEL_ID, MODEL> extends ReadRepository<MODEL_ID, MODEL> {
    List<MODEL> readAll();
}
