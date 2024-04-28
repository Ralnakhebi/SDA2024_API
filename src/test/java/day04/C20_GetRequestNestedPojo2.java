package day04;

import base_urls.RestFullBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.BookingDatesPojo;
import pojo.BookingPojo;
import pojo.BookingResponsePojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C20_GetRequestNestedPojo2 extends RestFullBaseUrl {
    @Test
    public void test(){

        //Set Url
        spec.pathParam("first","booking");
        //Set Expected Data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo payLoad = new BookingPojo("John","Smith",111
                , true, bookingDates, "Breakfast");

        //Send POST Request
        Response response = given(spec).body(payLoad).when().post("{first}");
        BookingResponsePojo actualData = response.as(BookingResponsePojo.class);

        //Do Assertions
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.getFirstname(),actualData.getBooking().getFirstname());
        assertEquals(payLoad.getLastname(),actualData.getBooking().getLastname());
        assertEquals(payLoad.getTotalprice(),actualData.getBooking().getTotalprice());
        assertEquals(payLoad.getDepositpaid(),actualData.getBooking().getDepositpaid());
        assertEquals(bookingDates.getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDates.getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(payLoad.getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());



    }
    /*
       Given
       1) https://restful-booker.herokuapp.com/booking
       2) {
               "firstname": "Jane",
               "lastname": "Doe",
               "totalprice": 111,
               "depositpaid": true,
               "bookingdates": {
                   "checkin": "2018-01-01",
                   "checkout": "2019-01-01"
               },
               "additionalneeds": "Extra pillows please"
           }
   When
       I send POST Request to the Url
   Then
       Status code is 200
       And response body should be like {
                            "bookingid": 2243,
                            "booking":{
                                       "firstname": "Jane",
                                       "lastname": "Doe",
                                       "totalprice": 111,
                                       "depositpaid": true,
                                       "bookingdates": {
                                              "checkin": "2018-01-01",
                                              "checkout": "2019-01-01"
                                                       },
                                                       "additionalneeds": "Extra pillows please"
                                                   }
                                            }
     */
}
