package com.jcoh.springRest.book;

import static io.restassured.RestAssured.get;
import io.restassured.RestAssured;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.BeforeClass;
import org.junit.Test;

public class BookControllerTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }


    @Test
    public void test() {
        get("/get-book-by-Id/1")
                .then()
                .body("id", equalTo(1))
                .body("name", equalTo("Idiot"))
                .body("autor", equalTo("Dostoyevskiy"));
    }
}