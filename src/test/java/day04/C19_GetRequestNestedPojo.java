package day04;

import base_urls.RestFullBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.BookingDatesPojo;
import pojo.BookingPojo;
import testdata.RestfulTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C19_GetRequestNestedPojo extends RestFullBaseUrl {
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
        BookingDatesPojo bookingdates = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData= new BookingPojo("John","Smith",111
                , true, bookingdates, "Breakfast");
        //Send GET request
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        //Do Assertions
        BookingPojo actualData = response.as(BookingPojo.class);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingdates.getCheckout(),actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());


    }
}
