package day04;

import base_urls.RestFullBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import testdata.RestfulTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C18_GetRequestNestedMap extends RestFullBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/827
    When
        I send GET Request to the url
    Then
        Status code should be 200
        Response body should be like that;
            {
                "firstname": "John","Smith", 111, true,bookingdates, "Breakfast"
            }
 */
    @Test
    public void test(){
        //Set Url
        spec.pathParams("first","booking"
        ,"second",451);
        //Set Expected data
        Map<String, Object> bookingdates= RestfulTestData.bookingDatesMapper("2018-01-01","2019-01-01");

        Map<String, Object> expectedData = RestfulTestData.bookingMapper("John"
                ,"Smith", 111, true,bookingdates, "Breakfast");

        //Send GET request
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        //Do Assertions
        Map<String,Object> actualData= response.as(Map.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));

        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));

        assertEquals(bookingdates.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdates.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));


        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));

        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));



    }
}
