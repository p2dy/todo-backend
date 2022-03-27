package com.example.core.domain;

import java.util.Optional;

public interface ReadService<MODEL_ID, MODEL> {
    Optional<MODEL> read(MODEL_ID modelId);
}
