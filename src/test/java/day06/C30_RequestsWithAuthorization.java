package day06;

import base_urls.GorestBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.booking.UserResponse;

import static io.restassured.RestAssured.given;
import static utilities.ObjectMapperUtilities.convertJsonToJava;

public class C30_RequestsWithAuthorization extends GorestBaseUrl {
    // token = 04a0bfadf55a182000dc1508895b8d3ea49f3987b0b7a3ae57950bfdff3c8156
    @Test
    public void createUser(){

        //Set Url
        spec.pathParam("first","users");
        spec.queryParam("id","6743944");
        //Set expected Data
        String expectedStr = """
                {
                        "meta": {
                            "pagination": {
                                "total": 1,
                                "pages": 1,
                                "page": 1,
                                "limit": 10,
                                "links": {
                                    "previous": null,
                                    "current": "https://gorest.co.in/public/v1/users?page=1",
                                    "next": null
                                }
                            }
                        },
                        "data": [
                            {
                                "id": 6743944,
                                "name": "Aagneya Asan",
                                "email": "aagneya_asan@ryan.test",
                                "gender": "female",
                                "status": "inactive"
                            }
                        ]
                    }""";
        UserResponse expectedData=convertJsonToJava(expectedStr,UserResponse.class);
        //Send Get Request
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();
        UserResponse actualData =convertJsonToJava(response.asString(), UserResponse.class);

    }


}
