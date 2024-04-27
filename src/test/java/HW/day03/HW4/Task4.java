package HW.day03.HW4;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Task4 extends CountBaseUrl{

    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12
    Note: Print using JsonPath: response.jsonPath().prettyPrint();
*/

    @Test
    public void countAvailablePet(){
        //Set Url

        //Send GET Request
        Response response = given(spec).when().get();
        response.jsonPath().prettyPrint();
        JsonPath json = response.jsonPath();
        List<String> women=  json.getList("products.category.usertype.findAll{it.usertype=='Women'}");
        System.out.println("women number = " + women.size());
        assertEquals(12, women.size());

    }
}
