package com.example.progress.domain;

import lombok.Value;

import java.util.UUID;

@Value
public class ColumnId {
    UUID value;
    public static ColumnId of(UUID value) {
        return new ColumnId(value);
    }
}
