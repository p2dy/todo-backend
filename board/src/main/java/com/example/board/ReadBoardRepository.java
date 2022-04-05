package com.example.board;

import com.example.core.ReadRepository;

import java.util.List;

public interface ReadBoardRepository<MODEL_ID, MODEL> extends ReadRepository<MODEL_ID, MODEL> {
    List<MODEL> readAll();
}
