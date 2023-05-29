package ar.soledadsasia;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
public class BookResourceIT extends BookResourceTest {
    // Execute the same tests but in packaged mode.
    @Test
    public void shouldGetABook() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
            .pathParams("id", 1).
        when()
            .get("/api/books/{id}").
        then()
            .statusCode(200)
            .body("title", is("Understanding Quarkus"))
            .body("author", is("Antonio Goncalves"))
            .body("yearOfPublication", is(2020))
            .body("genre", is("Information Technology"));
    }
}
