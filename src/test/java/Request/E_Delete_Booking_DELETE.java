package Request;
import static io.restassured.RestAssured.given;

import Utils.Routes;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class E_Delete_Booking_DELETE {

	public static Response deletebooking(int BookingID,String token) {
		RestAssured.baseURI=Routes.base_url;

		return given()
				.cookie("token", token)
				.log().all()
				.when()
				.delete(Routes.delete_booking_url + BookingID)
				.then()
				.log().all()
				.extract()
				.response();
	}
}
