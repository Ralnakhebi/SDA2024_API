package HW.day03.HwPojo.HW5;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Task5 extends PetStoreBaseUrl {

    //Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/"
    // document (All actions must be done on same pet)
    //(Use Pojo)

    public static PetPojo_HW5 payLoad;
    public Integer id = 12555553;
    @Test
    public void postRequest(){
        //Set Url
        spec.pathParam("first","pet");
        //Set expected Data
        //Create a List of tags to match Json Syntax type
        List<PetTagPojo_HW5> tagList= new ArrayList<>();
        tagList.add(new PetTagPojo_HW5(11,"Tag4"));

         payLoad = new PetPojo_HW5(id
                ,new PetCategoryPojo_HW5(555,"cat")
                ,"Kitten"
                ,new ArrayList<String>(Arrays.asList("image1","image2"))
                ,tagList
                ,"Available");

        //Sent POST Request
        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();

        PetPojo_HW5 actualData= response.as(PetPojo_HW5.class);
        //Do Assertions
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.getId(),actualData.getId());

        assertEquals(payLoad.getCategory().toString(), actualData.getCategory().toString());
        assertEquals(payLoad.getName(),actualData.getName());
        assertEquals(payLoad.getPhotoUrls(), actualData.getPhotoUrls());
        assertEquals(payLoad.getTags().toString(),actualData.getTags().toString());
        assertEquals(payLoad.getStatus(),actualData.getStatus());


    }

    @Test(dependsOnMethods = "postRequest")
    public void getRequest(){
        //Set Url
        spec.pathParams("first","pet"
                        ,"second",id);
        //Set expected Data
        //Create a List of tags to match Json Syntax type

        //Sent POST Request
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        PetPojo_HW5 actualData= response.as(PetPojo_HW5.class);
        //Do Assertions
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.getId(),actualData.getId());

        assertEquals(payLoad.getCategory().toString(), actualData.getCategory().toString());
        assertEquals(payLoad.getName(),actualData.getName());
        assertEquals(payLoad.getPhotoUrls(), actualData.getPhotoUrls());
        assertEquals(payLoad.getTags().toString(),actualData.getTags().toString());
        assertEquals(payLoad.getStatus(),actualData.getStatus());
    }

    @Test(dependsOnMethods = "postRequest")
    public void putRequest(){
        //Set Url
        spec.pathParams("first","pet");

        //Set expected Data
        //Change the Name to Luna
        payLoad.setName("Luna");
        //Create a List of tags to match Json Syntax type

        //Sent POST Request
        Response response = given(spec).body(payLoad).when().put("{first}");
        response.prettyPrint();

        PetPojo_HW5 actualData= response.as(PetPojo_HW5.class);
        //Do Assertions
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.getId(),actualData.getId());
        assertEquals(payLoad.getCategory().toString(), actualData.getCategory().toString());
        assertEquals(payLoad.getName(),actualData.getName());
        assertEquals(payLoad.getPhotoUrls(), actualData.getPhotoUrls());
        assertEquals(payLoad.getTags().toString(),actualData.getTags().toString());
        assertEquals(payLoad.getStatus(),actualData.getStatus());

    }

    @Test(dependsOnMethods = "postRequest",priority = 1)
    public void deleteRequest(){
        //Set Url
        spec.pathParams("first","pet"
                ,"second",id);
        //Set expected Data
        //Create a List of tags to match Json Syntax type

        //Sent POST Request
        Response response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();
        //Do Assertions For GET Request
        response
                .then()
                        .body("message",equalTo(id+""));
        assertEquals(200,response.statusCode());


        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        //Do Assertions
        assertEquals(404,response.statusCode());


    }




}
