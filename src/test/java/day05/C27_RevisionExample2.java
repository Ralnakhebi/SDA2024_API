package day05;

import base_urls.GorestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class C27_RevisionExample2 extends GorestBaseUrl {

    @Test
    public void test(){
        //Set Url
        spec.pathParam("first","users");
        //Send request and get response
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();
        JsonPath json =response.jsonPath();

        //Do assertions
        // Then The value of "pagination limit" is 10
        int limit= json.getInt("meta.pagination.limit");
        assertEquals(10, limit);

        //And The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        String currentLink = json.getString("meta.pagination.links.current");
        assertEquals("https://gorest.co.in/public/v1/users?page=1", currentLink);

        //And he number of users should  be 10
        List<Integer> ids=json.getList("data.id");
        assertEquals(10,ids.size());

        //And We have at least one "active" status
        List<String> status=json.getList("data.status");
        assertTrue(status.size()>0);

        //And "Abhaidev Kaur", "Fr. Deenabandhu Adiga", "Akshita Singh DC" are among the users -> Data may change
        response
                .then()
                .body("data.name", Matchers.hasItems("Msgr. Gati Mahajan","Draupadi Singh","Radha Mukhopadhyay"));

        //And The female users are less than or equals to male users -> Data may change
        List<Integer> male=json.getList("data.findAll{it.gender=='male'}.id");
        List<Integer> female=json.getList("data.findAll{it.gender=='female'}.id");
        assertTrue(female.size()<=male.size());
    }

}
