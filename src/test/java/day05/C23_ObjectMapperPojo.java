package day05;

import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.JsonPlaceHolderPojo;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C23_ObjectMapperPojo extends JsonPlaceHolderBaseUrl {


    @Test
    public void test() throws JsonProcessingException {
        //Set Url
        spec.pathParam("first", "todos");

        //Set expected data
        String expectedStr = """
                {
                  "userId": 55,
                  "title": "Tidy your room",
                  "completed": false
                  }""";

        ObjectMapper objectMapper=new ObjectMapper();
        JsonPlaceHolderPojo payLoad =objectMapper.readValue(expectedStr, JsonPlaceHolderPojo.class);
        //Send request and get response
        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();
        JsonPlaceHolderPojo actualData = objectMapper.readValue(response.asString(), JsonPlaceHolderPojo.class);

        //Do assertions
        assertEquals(201,response.statusCode());
        assertEquals(payLoad.getUserId(),actualData.getUserId());
        assertEquals(payLoad.getTitle(),actualData.getTitle());
        assertEquals(payLoad.getCompleted(),actualData.getCompleted());

    }

}
