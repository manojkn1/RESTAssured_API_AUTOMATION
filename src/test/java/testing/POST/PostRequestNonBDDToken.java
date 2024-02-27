package testing.POST;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PostRequestNonBDDToken {

    @Test
    public void getToken(){

        String payload= "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("auth");
        r.contentType(ContentType.JSON);

        Response response= r.when().post();
        ValidatableResponse vResponse= response.then();
        String responseString = response.asString();
        System.out.println(responseString);
        vResponse.statusCode(200);
    }
}
