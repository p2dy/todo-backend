package com.example.progress.domain;

import com.example.core.domain.Title;
import lombok.Value;

@Value
public class Progress {
    private static final Title DONE = Title.of("DONE");
    private static final Title TODO = Title.of("TODO");

    ProgressId id;
    Title title;
    int position;

    public static Progress todo(ProgressId progressId) {
        return create(progressId, TODO, 0);
    }

    public static Progress done(ProgressId progressId) {
        return create(progressId, DONE, 1);
    }

    public static Progress create(ProgressId progressId, Title title, int position) {
        return new Progress(progressId, title, position);
    }
}
