package com.example.task.boundary;

import com.example.board.domain.BoardId;
import com.example.core.domain.Title;
import com.example.progress.domain.ProgressId;
import com.example.task.domain.Task;
import com.example.task.domain.TaskId;
import lombok.Data;

import java.util.UUID;

import static com.example.progress.domain.ProgressId.EMPTY_PROGRESS_REFERENCE;

@Data
public class TaskDto {
    UUID boardReference;
    UUID progressReference;
    UUID uniqueId;
    String title;

    public static TaskDto from(Task task) {
        var result = new TaskDto();
        result.setBoardReference(task.getBoardReference().getValue());
        result.setProgressReference(task.getProgressReference().getValue());
        result.setUniqueId(task.getId().getValue());
        result.setTitle(task.getTitle().getValue());
        return result;
    }

    public Task model() {
        return Task.builder()
                .id(TaskId.of(uniqueId))
                .title(Title.of(title))
                .boardReference(BoardId.of(boardReference))
                .progressReference(progressReference == null ? EMPTY_PROGRESS_REFERENCE : ProgressId.of(progressReference))
                .build();
    }
}
