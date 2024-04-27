package HW.day03.HW4;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class CountBaseUrl {

    protected RequestSpecification spec;
    @BeforeMethod
    public void setUp(){
        spec =new RequestSpecBuilder()
                .setBaseUri("https://automationexercise.com/api/productsList")
                .setContentType(ContentType.JSON)
                .build();
    }
}
