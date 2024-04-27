package HW.day03.HwPojo.HW1;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Task1 extends HwBaseUrl {

    @Test
    public void postRequest(){
        //Set Url
        spec.pathParam("first","users");
        //Set expected Data
        Pojo_HW1 payLoad = new Pojo_HW1("morpheus","leader");

        //Sent POST Request
        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();

        Pojo_HW1 actualData= response.as(Pojo_HW1.class);
        //Do Assertions
        assertEquals(201,response.statusCode());
        assertEquals(payLoad.getName(),actualData.getName());
        assertEquals(payLoad.getJob(),actualData.getJob());


    }

      /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */
}
