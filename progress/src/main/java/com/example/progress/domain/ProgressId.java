package com.example.progress.domain;

import lombok.Value;

import java.util.UUID;

@Value
public class ProgressId {
    UUID value;
    public static ProgressId of(UUID value) {
        return new ProgressId(value);
    }
}
