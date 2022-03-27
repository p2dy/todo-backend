package com.example.progress.domain;

import com.example.core.domain.Title;
import lombok.Value;

@Value
public class Progress {
    private static final Title DONE = Title.of("DONE");
    private static final Title TODO = Title.of("TODO");

    ProgressId id;
    Title title;

    public static Progress todo(ProgressId progressId) {
        return new Progress(progressId, TODO);
    }

    public static Progress done(ProgressId progressId) {
        return new Progress(progressId, DONE);
    }

    public static Progress create(ProgressId progressId, Title title) {
        return new Progress(progressId, title);
    }
}
