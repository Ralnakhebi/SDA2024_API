package day03;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import testdata.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static testdata.JsonPlaceHolderTestData.jsonPlaceHolderMapper;

public class C12_PostRequestTestData extends JsonPlaceHolderBaseUrl {

    @Test
    public void jsonPlaceHolder(){
        spec.pathParam("first","todos");
        Map<String, Object> payLoad = jsonPlaceHolderMapper(55
                , "Tidy your room"
                , false);
        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();

    }

}
