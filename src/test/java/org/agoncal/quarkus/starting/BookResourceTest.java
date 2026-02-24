package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static io.restassured.RestAssured.given;


import static jakarta.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
class BookResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
                .header(ACCEPT, APPLICATION_JSON)
                .when().get("/api/books")
                .then()
                .statusCode(200)
                .body("size()", is(3));
    }

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