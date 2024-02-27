package testing.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteNonBDD {

    //id
    //url
    //cookie
  //  header
    String token="157d71f0ae0248b";

@Test
    public void deleteUser(){

        RequestSpecification r=RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/2376");
        r.cookie("token",token);
        r.contentType(ContentType.JSON);

       Response response= r.when().log().all().delete();

       ValidatableResponse vResponse =response.then();
       vResponse.statusCode(201);


    }
}
