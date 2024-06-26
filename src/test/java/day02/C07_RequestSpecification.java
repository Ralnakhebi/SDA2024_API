package day02;

import base_urls.RestFullBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.testng.AssertJUnit.assertTrue;

public class C07_RequestSpecification extends RestFullBaseUrl {


    @Test
    public void queryParametersTest() {

        //1. Set the URL
        spec.pathParams("first","booking")
                .queryParams("firstname","John"
                ,"lastname", "Smith");
        //2. Set the expected data

        //3. Send the request and get the response
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();
        //4. Do Assertion

        //1st way:
        response
                .then()
                .statusCode(200);

        String responseStr = response.asString();
        assertTrue(responseStr.contains("bookingid"));

        //2nd way:
        response
                .then()
                .statusCode(200)
                .body(containsString("bookingid"))
                .body("bookingid", Matchers.hasSize(greaterThan(0)));
    }
}
