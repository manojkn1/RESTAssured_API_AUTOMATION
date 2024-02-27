package testing.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PostRequestNonBDDTestNG {

    @Test
    public void createNewUserPositive(){

        String payload= "{\n" +
                "    \"firstname\" : \"manu\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        // Preparation of a request
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking");
        r.body(payload);
        r.contentType(ContentType.JSON);

       // Making a request
        Response response= r.when().post();

        // Validation part
        ValidatableResponse vResponse= response.then();
        String responseString = response.asString();
        System.out.println(responseString);
        vResponse.statusCode(200);


    }

}
