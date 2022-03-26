package com.example.progress.domain;

import lombok.Value;

@Value
public class ColumnId {
    public static ColumnId defaultId() {
        return new ColumnId();
    }
}
