package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class MonitoringHealthCheckIT {

    @Test
    public void callShouldReturnUp() {
        given()
                .when()
                .get("/q/health/live")
                .then()
                .statusCode(200)
                .and().body(containsString("name-test"))
                .and().body(containsString("major-test.minor-test.patch-test"));
    }

}