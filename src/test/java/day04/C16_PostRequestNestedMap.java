package day04;

import base_urls.RestFullBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C16_PostRequestNestedMap extends RestFullBaseUrl {

    @Test
    public void postNestedMapTest(){
        //Set Url
        spec.pathParam("first","booking");
        //Set Expected Data

        //While dealing with Nested structure start from the inner part
        Map<String,Object> bookingdates= new HashMap<>();
        bookingdates.put("checkin","2023-03-07");
        bookingdates.put("checkout","2024-09-25");

        Map<String,Object>payLoad=new HashMap<>();
        payLoad.put("firstname","John");
        payLoad.put("lastname", "Doe");
        payLoad.put("totalprice", 15);
        payLoad.put("depositpaid",true);
        payLoad.put("bookingdates",bookingdates);
        payLoad.put("additionalneeds", "Lunch");
        //Send POST request
        Response response=given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();
        Map<String,Object> actualData=response.as(Map.class);
        //Do Assertions
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.get("firstname"),((Map)(actualData.get("booking"))).get("firstname"));
        assertEquals(payLoad.get("lastname"),((Map)(actualData.get("booking"))).get("lastname"));
        assertEquals(payLoad.get("totalprice"),((Map)(actualData.get("booking"))).get("totalprice"));
        assertEquals(payLoad.get("depositpaid"),((Map)(actualData.get("booking"))).get("depositpaid"));
        assertEquals(bookingdates.get("checkin"),((Map)(((Map)(actualData.get("booking"))).get("bookingdates"))).get("checkin"));
        assertEquals(bookingdates.get("checkout"),((Map)(((Map)(actualData.get("booking"))).get("bookingdates"))).get("checkout"));
        assertEquals(payLoad.get("additionalneeds"),((Map)(actualData.get("booking"))).get("additionalneeds"));

    }
    /*
    Given
        1) https://restful-booker.herokuapp.com/booking
        2) {
            "firstname": "John",
            "lastname": "Doe",
            "totalprice": 15,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2023-03-07",
                "checkout": "2024-09-25"
            },
            "additionalneeds": "Lunch"
           }
    When
        I send POST Request to the Url
    Then
        Status code is 200
        And response body should be like {
                                            "bookingid": 2243,
                                            "booking": {
                                                "firstname": "John",
                                                "lastname": "Doe",
                                                "totalprice": 471,
                                                "depositpaid": true,
                                                "bookingdates": {
                                                    "checkin": "2023-03-07",
                                                    "checkout": "2024-09-25"
                                                },
                                                "additionalneeds": "Lunch"
                                            }
                                        }
 */
}
