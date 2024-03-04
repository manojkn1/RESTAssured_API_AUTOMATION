package testing.Misc.PayloadManage;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import testing.Misc.gson.Booking;
import testing.Misc.gson.Bookingdates;

import java.util.LinkedHashMap;
import java.util.Map;

public class PayloadusingClass {

    RequestSpecification r;
    Response response;
    ValidatableResponse vResponse;

    @Test
    public void testPostRequest1(){
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

        Booking booking= new Booking();
        booking.setFirstname("manoj");
        booking.setLastname("brown");
        booking.setTotalprice(100);
        booking.setAdditionalneeds("breakfast");
        booking.setDepositpaid(true);

        Bookingdates bookingdates=new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

        booking.setBookingdates(bookingdates);

        // Preparation of a request
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking");
        r.body(booking);
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
