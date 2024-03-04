package testing.Misc.PayloadManage;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class PayloadManageUsingMap {

    RequestSpecification r;
    Response response;
    ValidatableResponse vResponse;

    @Test
    public void testPostRequest(){
       /* String payload= "{\n" +
                "    \"firstname\" : \"manu\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";*/

        Map<String,Object>  payloadUsingMap= new LinkedHashMap<>();

        Faker faker = new Faker();

        payloadUsingMap.put("firstname",faker.name().fullName());
        payloadUsingMap.put("lastname",faker.name().lastName());
        payloadUsingMap.put("totalprice",faker.number().numberBetween(1,200));
        payloadUsingMap.put("depositpaid",faker.random().nextBoolean());
        payloadUsingMap.put("additionalneeds","Breakfast");

        Map<String,Object>  bookingdatesMAp= new LinkedHashMap<>();
        bookingdatesMAp.put("checkin","2018-01-01");
        bookingdatesMAp.put("checkout","2019-01-01");

        payloadUsingMap.put("bookingdates",bookingdatesMAp);





        // Preparation of a request
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking");
        r.body(payloadUsingMap);
        r.contentType(ContentType.JSON);

        // Making a request
        response= r.when().post();

        // Validation part
        vResponse= response.then().log().all();

        Integer bookingID= response.then().extract().path("bookingid");
        System.out.println("booking id is--->" +bookingID);
        vResponse.statusCode(200);

    }
}
