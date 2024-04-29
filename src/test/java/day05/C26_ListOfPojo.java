package day05;

import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.JsonPlaceHolderPojo;
import utilities.ObjectMapperUtilities;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertTrue;
import static utilities.ObjectMapperUtilities.convertJsonToJava;

public class C26_ListOfPojo extends JsonPlaceHolderBaseUrl {
    @Test
    public void test() throws JsonProcessingException {
        //Set Url
        spec.pathParam("first","todos");

        //Set expected Data
        String expectedStr= """
                {
                    "userId": 1,
                    "id": 4,
                    "title": "et porro tempora",
                    "completed": true
                }""";
        JsonPlaceHolderPojo expectedData = convertJsonToJava(expectedStr, JsonPlaceHolderPojo.class);

        //Send request and get response
        Response response = given(spec).when().get("{first}");
        //response.prettyPrint();
        JsonPlaceHolderPojo[] actualData = convertJsonToJava(response.asString(),  JsonPlaceHolderPojo[].class);

        //Do assertions
        boolean isThere=false;
        for (JsonPlaceHolderPojo actualDatum : actualData) {
            if (actualDatum.getId() == 4) {
                if (actualDatum.getUserId() == expectedData.getUserId()
                        && actualDatum.getTitle().equals(expectedData.getTitle())
                        && actualDatum.getCompleted() == expectedData.getCompleted())
                    isThere = true;
            }
        }
        System.out.println("isThere = " + isThere);
        assertTrue(isThere);
        }

}
