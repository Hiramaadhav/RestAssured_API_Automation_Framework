package Request;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import Utils.Routes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class D_Partial_Update_Booking_PATCH {

	public static Response partialupdatebooking(int BookingID,String token) {
		RestAssured.baseURI=Routes.base_url;

		Map<String,Object> payload=new HashMap<>();
		payload.put("depositpaid",false);
		payload.put("additionalneeds","Dinner");

		return given()
				.contentType(ContentType.JSON)
				.cookie("token",token)
				.body(payload)
				.log().all()
				.when()
				.patch(Routes.partial_update_booking_url + BookingID)
				.then()
				.log().all()
				.extract()
				.response();
	}
}
