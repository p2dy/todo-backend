package com.example.progress.domain;

import lombok.Value;

import java.util.UUID;

@Value
public class ProgressId {
    public static final ProgressId EMPTY_PROGRESS_REFERENCE = of(null);

    UUID value;

    public static ProgressId of(UUID value) {
        return new ProgressId(value);
    }

    public boolean isEmpty() {
        return this.equals(EMPTY_PROGRESS_REFERENCE);
    }
}
