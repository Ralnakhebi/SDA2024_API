package ApiTest;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FirstApiTest {


    /*
    Given Send GET request to https://reqres.in/api/users?page=2
    Then print status code
    And print status line
     */
    @Test
    public void test1(){

        String url ="https://reqres.in/api/users?page=2";
        Response response = given().when().get(url);
        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
    }


}
