package Request;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import Utils.Routes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class C_Update_Booking_PUT {

	public static Response updatebooking(int BookingID,String token) {
		RestAssured.baseURI=Routes.base_url;

		Map<String,Object> payload=new HashMap<>();
		payload.put("firstname","Meghana");
		payload.put("lastname","Hira");
		payload.put("totalprice",1250);
		payload.put("depositpaid",true);
		Map<String,String> datepayload=new HashMap<>();
		datepayload.put("checkin","2024-02-01");
		datepayload.put("checkout","2024-02-15");
		payload.put("bookingdates", datepayload);
		payload.put("additionalneeds","breakfast");

		return given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Accept", "application/json")
				.cookie("token",token)
				.body(payload)
				.log().all()
				.when()
				.put(Routes.update_booking_url + BookingID)
				.then()
				.log().all()
				.extract()
				.response();
	}
}
