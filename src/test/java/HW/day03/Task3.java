package HW.day03;

import HW.day03.HwPojo.HW5.PetStoreBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Task3 extends PetStoreBaseUrl {

    //Using the https://petstore.swagger.io/ document, write an automation test that
    // finds the number of "pets" with the status "available" and asserts that there are more than 100.

    @Test
    public void countAvailablePet(){
        //Set Url
        spec.pathParams("first","pet"
        ,"second", "findByStatus");
        spec.queryParam("status","available");
        //Send GET Request
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        JsonPath json = response.jsonPath();
        List<Integer> availableId=  json.getList("findAll{it.status=='available'}.id");
        System.out.println("availableId = " + availableId);
        assertTrue(availableId.size()>100);

    }
}
