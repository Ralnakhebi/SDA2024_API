package HW.day02;

import HW.day03.HwPojo.HW1.HwBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Task3 extends HwBaseUrl {



    @Test
    public void task3(){
        //Set Up Url
        spec.pathParam("first","unknown");
        //Send GET Request



        Response response = given(spec).when().get("{first}");
        //1)Status code is 200
        response.then().statusCode(200);
        JsonPath json = response.jsonPath();
        //2)Print all pantone_values
        System.out.println("pantone_values = " + json.getList("data.pantone_value"));

        //List<Object> listNames = json.getList("data");
        //3)Print all ids greater than 3 on the console
        //Assert that there are 3 ids greater than 3
        List<Integer> listIds = json.getList("data.findAll{it.id>3}.id");
        System.out.println("ids greater than 3 = " + listIds);
        assertEquals(3,listIds.size());

        //4)Print all names whose ids are less than 3 on the console


        List<String> listNames = json.getList("data.findAll{it.id<3}.name");
        System.out.println("names whose ids are less than 3 = " + listNames);
        //Assert that the number of names whose ids are less than 3 is 2
        assertEquals(2, listNames.size());

    }
}
