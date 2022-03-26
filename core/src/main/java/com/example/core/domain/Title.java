package com.example.core.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class Title {
    String value;
}
