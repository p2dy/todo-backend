package com.example.core.domain;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class UniqueIdProvider {
    public UUID generate() {
        return UUID.randomUUID();
    }
}
