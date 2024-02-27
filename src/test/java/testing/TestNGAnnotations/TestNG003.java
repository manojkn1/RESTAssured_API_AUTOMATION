package testing.TestNGAnnotations;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestNG003 {
    String token;
    RequestSpecification r;
    Response response;
    ValidatableResponse vResponse;

   @BeforeTest
    public void getToken(){
        String payload= "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("auth");
        r.contentType(ContentType.JSON);

        response= r.when().post();

        vResponse= response.then();
        String responseString = response.asString();
        System.out.println(responseString);
        vResponse.statusCode(200);

        token= response.then().log().all().extract().path("token");// to extract


    }
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
         r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/3794");
        r.cookie("token",token);
        r.contentType(ContentType.JSON);
        r.body(payload);

       response=r.when().log().all().put();

        vResponse=response.then();
        String sResponse= response.asString();
        System.out.println(sResponse);
        vResponse.statusCode(200);
        vResponse.body("firstname", Matchers.equalTo("Manoj"));// Matchers assertipns
        vResponse.body("lastname", Matchers.equalTo("Brown")); //// Matchers assertipns

        Assert.assertNotNull(token);// Using testNg assertion











    }
}
