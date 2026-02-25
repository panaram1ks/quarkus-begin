package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
class BookResourceIT extends BookResourceTest {

    // we able override test from jvm mode to native mode
    @Test
    void shouldGetABook() {
        given()
                .header(ACCEPT, APPLICATION_JSON)
                .pathParam("id", 1)
                .when()
                .get("/api/books/{id}")
                .then()
                .statusCode(OK.getStatusCode())
                .body("title", is("Title1"))
                .body("yearOfPublication", is(2025))
                .body("genre", is("IT"));
    }
}
