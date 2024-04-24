package HW.day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Task1 {

    @Test
    public void task2(){
        //Given https://reqres.in/api/users/3
        //When User sends a GET Request to the url
        String url = "https://reqres.in/api/users/3";
        Response response = given().when().get(url);
        //Then HTTP Status Code should be 200
        //And Content Type should be JSON
        //And Status Line should be HTTP/1.1 200 OK
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .statusLine("HTTP/1.1 200 OK");
    }
}
