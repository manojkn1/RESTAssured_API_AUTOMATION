package testing.Misc.PayloadManage;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import testing.Misc.gson.Booking;
import testing.Misc.gson.BookingResponse;
import testing.Misc.gson.Bookingdates;

import static org.assertj.core.api.Assertions.*;

public class PostRequestUsingSer_DSer {

    // Step1 - POST
    // URL -> Base URI + base Path
    // HEADER
    // BODY
    // Auth - NO


    // Step 2
    // prepare the Payload ( Object -> JSON String)
    // send the request

    //Step 3
    // Validate Response ( JSON String -> Object)
    // FirstName,
    // Status Code
    // Time Response



    RequestSpecification r;
    Response response;
    ValidatableResponse vResponse;

    @Test
    public void testPostRequest1(){
      //Preparation of payload

        Faker faker= new Faker();

        Booking booking= new Booking();
        String expFirstname =faker.name().firstName();
        booking.setFirstname(expFirstname);
        booking.setLastname("brown");
        booking.setTotalprice(100);
        booking.setAdditionalneeds("breakfast");
        booking.setDepositpaid(true);

        Bookingdates bookingdates=new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

        booking.setBookingdates(bookingdates);
        // Object -> JSON String (GSON)
        Gson gson=new Gson();
        String jsonBookingPayload=gson.toJson(booking);
        System.out.println(jsonBookingPayload);



        // Preparation of a request
       r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking");
        r.body(jsonBookingPayload);
        r.contentType(ContentType.JSON);

        // Making a request
        response= r.when().post();
       String jsonString= response.asString();

        vResponse= response.then().log().all();
        vResponse.statusCode(200);


        // Validate Response ( JSON String -> Object)
        BookingResponse bookingResponseObject=gson.fromJson(jsonString,BookingResponse.class);
        /*assertThat(bookingResponseObject.getBookingid()).isNotNull();
        assertThat(bookingResponseObject.getBooking().getFirstname()).isEqualTo(expFirstname);

*/
        //assertThat(bookingResponseObject.getBookingid()).isNotNull();
        Assert.assertNotNull(bookingResponseObject);
        Assert.assertEquals(bookingResponseObject.getBooking().getFirstname(),expFirstname);

        System.out.println(bookingResponseObject);


    }
}
