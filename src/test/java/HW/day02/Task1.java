package HW.day02;

import HW.day03.HwPojo.HW1.HwBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Task1 extends HwBaseUrl {
    @Test
    public void task1(){
        // Given https://reqres.in/api/users/2
        spec.pathParams("first","users"
                ,"second","2");
        //When User send GET Request to the URL
        Response response = given(spec).when().get("{first}/{second}");
        //Then HTTP Status Code should be 200
        //And Response format should be "application/json"
        //And "email" is "janet.weaver@reqres.in",
        //And"first_name" is "Janet"
        //And"last_name" is "Weaver"
        //And"text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.email",equalTo("janet.weaver@reqres.in")
                        ,"data.first_name",equalTo("Janet")
                        ,"data.last_name",equalTo("Weaver")
                        ,"support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }

}
