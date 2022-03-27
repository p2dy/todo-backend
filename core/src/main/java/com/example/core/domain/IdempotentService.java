package com.example.core.domain;

import java.util.Optional;

public abstract class IdempotentService<ModelId, Model extends WithId<ModelId>> {

    public Model createIdempotent(Model model) {
        return read(model.getId()).orElseGet(() -> create(model));
    }

    public abstract Model create(Model model);
    public abstract Optional<Model> read(ModelId id);
}
