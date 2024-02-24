package testing;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetRequestNonBDDTestNG {

    @Test
    public void getSingleBookingPositive(){
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/226");

        r.when().log().all().get();

        r.then().log().all().statusCode(200);

    };

    @Test
    public void getSingleBookingNegetive(){
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/-1");

        r.when().log().all().get();

        r.then().log().all().statusCode(404);

    };

    @Test
    public void getSingleBookingNegetive2(){
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/abc");

        r.when().log().all().get();

        r.then().log().all().statusCode(404);

    };

}
