package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MonitoringHealthCheckTest {

    @Test
    public void callShouldReturnUp() {
        given()
                .when()
                .get("/q/health/live")
                .then()
                .statusCode(200)
                .and().body(containsString("todo-backend"))
                .and().body(containsString("major-test.minor-test.patch-test"));
    }

}