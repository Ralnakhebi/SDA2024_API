package day01;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.Header;

import static io.restassured.RestAssured.given;

public class C01_RequestAndResponse {
    public static void main(String[] args) {

        //Given https://restful-booker.herokuapp.com/booking
        String url = "https://restful-booker.herokuapp.com/booking";
        //When User sends a GET Request to the url
        Response response = given().get(url);//all
        response.prettyPrint();
        System.out.println("-----------------------------");

        //Then Print Status Code (should be 200)
        int statuCode =response.statusCode();
        System.out.println("statuCode: "+statuCode);
        System.out.println("-----------------------------");

        //And Print Content Type (should be JSON)
        String contentType =response.contentType();
        System.out.println("contentType: "+contentType);
        System.out.println("-----------------------------");

        //And Print Status Line (should be HTTP/1.1 200 OK)
        String statusLine =response.statusLine();
        System.out.println("statusLine: "+statusLine);
        System.out.println("-----------------------------");

        //And Print Connection and Date headers on console
        String connection =response.header("Connection");
        System.out.println("connection: "+connection);
        System.out.println("-----------------------------");

        String date =response.header("Date");
        System.out.println("date: "+date);
        System.out.println("-----------------------------");

        //And Print all headers on console
        Headers headers= response.headers();
        System.out.println(headers);
        System.out.println("-----------------------------");

        //How to get response time
        System.out.println(response.time()+" ms");
        System.out.println("-----------------------------");

    }
}
