package com.example.board.domain;

import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class BoardId {
    UUID value;
}
