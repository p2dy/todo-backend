package com.example.progress.boundary;

import com.example.progress.domain.Progress;
import com.example.progress.domain.Progresses;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ProgressDto {
    UUID uniqueId;
    String title;
    int position;

    public static ProgressDto from(Progress model) {
        var progressDto = new ProgressDto();
        progressDto.setUniqueId(model.getId().getValue());
        progressDto.setTitle(model.getTitle().getValue());
        progressDto.setPosition(model.getPosition());
        return progressDto;
    }

    static List<ProgressDto> from(Progresses progresses) {
        return progresses.getValues().stream().map(ProgressDto::from).toList();
    }
}
