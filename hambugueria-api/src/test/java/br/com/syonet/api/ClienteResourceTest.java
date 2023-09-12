package br.com.syonet.api;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;


import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ClienteResourceTest {

    @Test
    void testGetCliente() {
        given()
            .auth()
            .basic( "admin", "admin" )
            .when()
            .queryParam( "email", "jonathan@syonet.com" )
            .queryParam( "documento", "12312312412" )
            .get( "/cliente" )
            .then()
            .statusCode( 200 );
    }
    
}
