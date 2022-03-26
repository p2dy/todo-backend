package com.example.progress.domain;

import com.example.board.domain.Board;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
public class CreateProgressColumnService {
    public void createDefaultFor(Board board) {
        log.info("write ProgressColumns for " + board.getTitle());
    }
}
