package ApiTest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class StaticImportBaseURI {
    /*
Given Send GET request by adding static import to the class
Then assert that status code is 200
And assert that status line is HTTP/1.1 200 OK
 */

    @Test
    public void test2(){
        baseURI ="https://reqres.in/api";
        Response response = given().when().pathParams("first","users").get("/{first}");
        response
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void test03(){
        baseURI = "https://reqres.in/api";

        Response response = given()
                .pathParams("first" , "users")
                .queryParams("page", 2).get("/{first}");

        response.then().log().headers();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
    }

}
