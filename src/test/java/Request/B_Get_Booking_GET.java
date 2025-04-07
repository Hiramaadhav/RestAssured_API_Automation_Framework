package Request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import Utils.Routes;

public class B_Get_Booking_GET {

	public static Response getbooking(int BookingID) {
		RestAssured.baseURI=Routes.base_url;
		return given()
				.header("Accept","application/json")
				.log().all()
				.when()
				.get(Routes.get_booking_url + BookingID)
				.then()
				.log().all()
				.extract()
				.response();
	}
}
