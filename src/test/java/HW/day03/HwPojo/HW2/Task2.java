package HW.day03.HwPojo.HW2;

import HW.day03.HwPojo.HW5.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Task2 extends PetStoreBaseUrl {

    /*
        Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
        */
    @Test
    public void createUser(){
        //Set Url
        spec.pathParam("first","user");
        //Set Expected Data
        UserPojo_HW2 payLoad =new UserPojo_HW2(0
                ,"UserTest"
                ,"userFirstName"
                ,"userLastName"
                ,"email@test"
                ,"2138"
                ,"12555555"
                ,0);

        //Send POST Request
        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();
        //Do Assertions
        assertEquals(200,response.statusCode());
        spec.pathParam("second",payLoad.getUsername());
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        UserPojo_HW2 actualData = response.as(UserPojo_HW2.class);
        //Do Assertions For GET Request
        assertEquals(payLoad.getUsername(), actualData.getUsername());
        assertEquals(payLoad.getFirstName(),actualData.getFirstName());
        assertEquals(payLoad.getLastName(), actualData.getLastName());
        assertEquals(payLoad.getEmail(), actualData.getEmail());
        assertEquals(payLoad.getPassword(),actualData.getPassword());
        assertEquals(payLoad.getPhone(), actualData.getPhone());


    }




}
