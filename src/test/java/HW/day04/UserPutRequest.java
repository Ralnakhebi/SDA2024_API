package HW.day04;

import HW.day03.HwPojo.HW2.UserPojo_HW2;
import HW.day03.HwPojo.HW5.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utilities.ObjectMapperUtilities.convertJsonToJava;

public class UserPutRequest extends PetStoreBaseUrl {

    @Test
    public void putRequest(){

        //SetUrl
        spec.pathParams("first","user","second","Ralnakhebi2114");
        //Set expected Data
        String expectedStr = """
                {
                  "id": 0,
                  "username": "Ralnakhebi2114",
                  "firstName": "Reemah",
                  "lastName": "alnakhebi",
                  "email": "test@test",
                  "password": "5482",
                  "phone": "12456987",
                  "userStatus": 0
                }""";

        UserPojo_HW2 expectedData= convertJsonToJava(expectedStr,UserPojo_HW2.class);

        //Send Post Request and get Response
        Response response = given(spec).body(expectedData).when().put("{first}/{second}");
        response.prettyPrint();

        //Do assertions
        assertEquals(200,response.statusCode());

    }
}
