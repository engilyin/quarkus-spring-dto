package org.acme.resteasy;

import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.acme.data.SimpleContactDto;
import org.acme.data.SimpleContactProjection;
import org.acme.entities.Contact;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ContactResourceTest {

    @Test
    public void testList() {
        List<Contact> contacts = when().get("/api/contact")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList(".", Contact.class);

        assertThat(contacts).hasSize(2);
    }

    @Test
    public void testFullObject() {
        Contact contact = when().get("/api/contact/jane")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getObject(".", Contact.class);

        assertThat(contact).isNotNull();
    }

    @Test
    public void testDto() {
        SimpleContactDto dto = when().get("/api/dto/jane")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getObject(".", SimpleContactDto.class);

        assertThat(dto).isNotNull();
    }

    @Test
    public void testProjection() {
        SimpleContactProjection projection = when().get("/api/projection/jane")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getObject(".", SimpleContactProjection.class);

        assertThat(projection).isNotNull();
    }

//    @Test
//    public void testDynamic() {
//        SimpleContactDto dto = when().get("/api/dynamic/jane")
//                .then()
//                .statusCode(200)
//                .extract()
//                .body()
//                .jsonPath()
//                .getObject(".", SimpleContactDto.class);
//
//        assertThat(dto).isNotNull();
//    }

}