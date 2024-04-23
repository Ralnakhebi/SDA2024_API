package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class C02_HeaderAssertions {

    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
    And
        Connection should be keep-alive
*/


    @Test
    public void headerTest(){
        //While doing api test you can follow the following steps:

        //1- Set Url
        String url = "https://restful-booker.herokuapp.com/booking";
        //2- Set expected data( if we expect data in certain format) or payload (if we use PUT or POST)

        //3- Sent request and get response
        /*given()
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK")
                .header("Connection","keep-alive"); */
        Response response= given().when().get(url);
        response.prettyPrint();

        //4- Do Assertions
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .statusLine("HTTP/1.1 200 OK")
                .header("Connection","keep-alive");

        int statusCode= response.statusCode();
        assertEquals(200,statusCode);
        String statusLine = response.statusLine();
        assertEquals("HTTP/1.1 200 OK",statusLine);


    }

}
