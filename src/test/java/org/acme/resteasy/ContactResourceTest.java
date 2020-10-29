package org.acme.resteasy;

import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;

import org.acme.entities.Contact;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ContactResourceTest {

    @Test
    public void testHelloEndpoint() {
        var contacts = when().get("/api/contact")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList(".", Contact.class);
        
        assertThat(contacts).hasSize(2);
    }

}