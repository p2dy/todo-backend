package com.example;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped
public class MonitoringHealthCheck implements HealthCheck {
    @ConfigProperty(name = "quarkus.application.version")
    String version;

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse
                .named("todo-backend")
                .withData("version", version)
                .up().build();
    }
}
