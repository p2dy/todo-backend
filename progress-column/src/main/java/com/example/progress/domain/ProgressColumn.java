package com.example.progress.domain;

import com.example.core.domain.Title;
import lombok.Value;

@Value
public class ProgressColumn {
    private static final Title DONE = Title.of("DONE");
    private static final Title TODO = Title.of("TODO");

    ColumnId id;
    Title title;

    public static ProgressColumn todo(ColumnId columnId) {
        return new ProgressColumn(columnId, TODO);
    }

    public static ProgressColumn done(ColumnId columnId) {
        return new ProgressColumn(columnId, DONE);
    }
}
