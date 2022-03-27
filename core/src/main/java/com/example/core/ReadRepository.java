package com.example.core;

import java.util.Optional;

public interface ReadRepository<MODEL_ID, MODEL> {
    Optional<MODEL> read(MODEL_ID modelId);
}
