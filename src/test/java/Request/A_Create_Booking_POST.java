package Request;

import POJO.Booking;
import POJO.BookingDates;
import Utils.Routes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class A_Create_Booking_POST {

	public static Response createbooking() {
		RestAssured.baseURI=Routes.base_url;

		Booking payload=new Booking();
		payload.setFirstname("Maadhav");
		payload.setLastname("Hira");
		payload.setTotalprice(1000);
		payload.setDepositpaid(true);

		BookingDates datepayload=new BookingDates();
		datepayload.setCheckin("2024-02-01");
		datepayload.setCheckout("2024-02-10");

		payload.setBookingdates(datepayload);
		payload.setAdditionalneeds("breakfast");

		return given()
				.contentType(ContentType.JSON)
				.body(payload)
				.log().all()
				.when()
				.post(Routes.Create_Booking_url)
				.then()
				.log().all()
				.extract()
				.response();
	}
}
