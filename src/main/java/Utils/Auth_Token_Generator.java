package Utils;

import POJO.Auth;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Auth_Token_Generator {

	public static String get_token() {
		RestAssured.baseURI=Routes.base_url;
		Auth payload=new Auth("admin","password123");
		Response response=given()
				.header("Content-Type","application/json")
				.body(payload)
				.log().all()
				.when()
				.post(Routes.auth_url)
				.then()
				.log().all()
				.extract()
				.response();
		return response.jsonPath().getString("token");
	}
}
