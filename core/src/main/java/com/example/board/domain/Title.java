package com.example.board.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class Title {
    String value;
}
