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

    @ConfigProperty(name = "quarkus.application.name")
    String applicationName;

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse
                .named(applicationName)
                .withData("version", version)
                .up().build();
    }
}
