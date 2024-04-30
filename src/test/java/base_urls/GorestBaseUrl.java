package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class GorestBaseUrl {

    protected RequestSpecification spec;
    String token="04a0bfadf55a182000dc1508895b8d3ea49f3987b0b7a3ae57950bfdff3c8156";
    @BeforeMethod
    public void setUp(){
        spec =new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/public/v1")
                .addHeader("Authorization","Bearer "+token)
                .setContentType(ContentType.JSON)
                .build();
    }
}

