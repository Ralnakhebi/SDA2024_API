package HW;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertTrue;

public class Task2 {

     /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void task2(){
        //Given https://reqres.in/api/users/23
        //When User sends a GET Request to the url
        String url = "https://reqres.in/api/users/23";
        Response response = given().when().get(url);
        //Then HTTP Status code should be 404
        //And Status Line should be HTTP/1.1 404 Not Found
        //And Server is "cloudflare"
        //And Response body should be empty
        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server",equalTo("cloudflare"))
                .body("[0]",is(nullValue()));
        assertTrue(response.body().asPrettyString().contains(""));
    }
}
