package testing.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPUT {
    String token= "6049f842e443968";
@Test
    public void putRequest(){

        // url
        //header, auth or cookie
        // paylod
        // id  2948

        String payload = "{\n" +
                "    \"firstname\" : \"Manoj\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 100,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/1021");
        r.cookie("token",token);
        r.contentType(ContentType.JSON);
        r.body(payload);

        Response response=r.when().log().all().put();

        ValidatableResponse vResponse=response.then();
        String sResponse= response.asString();
        System.out.println(sResponse);
        vResponse.statusCode(200);
        vResponse.body("firstname", Matchers.equalTo("Manoj"));
        vResponse.body("lastname", Matchers.equalTo("Brown"));




    }
}
