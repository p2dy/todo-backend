package com.example.core;

import java.util.Optional;

public interface ReadRepository<MODEL_ID, MODEL> {
    Optional<MODEL> readBy(MODEL_ID modelId);
}
