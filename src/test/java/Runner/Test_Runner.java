package Runner;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import Base.Base_Class;
import Request.A_Create_Booking_POST;
import Request.B_Get_Booking_GET;
import Request.C_Update_Booking_PUT;
import Request.D_Partial_Update_Booking_PATCH;
import Request.E_Delete_Booking_DELETE;
import Utils.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;


@Epic("RestAssured Automation")
@Feature("Booking Module")
public class Test_Runner extends Base_Class {

	int BookingID;
	String token;

	@BeforeClass
	public void setup() {
		extent=Extent_Report_Manager.initReport();
		token = Auth_Token_Generator.get_token();
		log.info("Base URI and Token setup Completed");
	}

	@Test(priority=1)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Create a new booking")
	@Story("Create Booking")
	public void createbooking() {
		test=extent.createTest("Create Booking");
		Response response=A_Create_Booking_POST.createbooking();
		BookingID=response.jsonPath().getInt("bookingid");
		log.info("Booking ID Generated");
		Assert.assertEquals(response.statusCode(),200);
		log.info("Verified that Status code is 200");
		Assert.assertEquals(response.statusLine(),"HTTP/1.1 200 OK");
		log.info("Verified that Status line is HTTP/1.1 200 OK");
		log.info("Created the Booking");
		test.log(Status.INFO,"Booking Created With ID " + BookingID + "And Token Generated with ID " + token);
	}

	@Test(priority=2)
	@Severity(SeverityLevel.MINOR)
	@Description("Retrieve the created booking")
	@Story("Get Booking")
	public void getbooking() {
		test=extent.createTest("Get Booking");
		Response response=B_Get_Booking_GET.getbooking(BookingID);
		Assert.assertEquals(response.statusCode(),200);
		log.info("Verified that Status code is 200");
		Assert.assertEquals(response.statusLine(),"HTTP/1.1 200 OK");
		log.info("Verified that Status line is HTTP/1.1 200 OK");
		log.info("Booking is verified by checking it");
		test.log(Status.INFO,"Retrived Booking of " + BookingID );
	}

	@Test(priority=3)
	@Severity(SeverityLevel.NORMAL)
	@Description("Updating the booking")
	@Story("Update Booking")
	public void updatebooking() {
		test=extent.createTest("Update Booking");
		Response response=C_Update_Booking_PUT.updatebooking(BookingID, token);
		Assert.assertEquals(response.statusCode(),200);
		log.info("Status code verified");
		Assert.assertEquals(response.statusLine(),"HTTP/1.1 200 OK");
		log.info("Status Line is Verified");
		String firstname=response.jsonPath().getString("firstname");
		Assert.assertEquals(firstname,"Meghana");
		log.info("Verified that after Update firstname is Meghana");
		String checkout=response.jsonPath().getString("bookingdates.checkout");
		Assert.assertEquals(checkout,"2024-02-15");
		log.info("Verified that after Update checkout date is 2024-02-15");
		log.info("Updated the Booking");
		test.log(Status.INFO,"Booking Updated");
	}

	@Test(priority=4)
	@Severity(SeverityLevel.TRIVIAL)
	@Description("Partially Updating booking")
	@Story("Partially Updating Booking")
	public void partialupdatebooking() {
		test=extent.createTest("Partial Update Booking");
		Response response=D_Partial_Update_Booking_PATCH.partialupdatebooking(BookingID, token);
		Assert.assertEquals(response.statusCode(),200);
		log.info("Verified that Status code is 200");
		Assert.assertEquals(response.statusLine(),"HTTP/1.1 200 OK");
		log.info("Verified that Status line is HTTP/1.1 200 OK");
		boolean depositpaid=response.jsonPath().getBoolean("depositpaid");
		Assert.assertFalse(depositpaid);
		log.info("Verified that after Update depositpaid date is false");
		String additionalneeds=response.jsonPath().getString("additionalneeds");
		Assert.assertEquals(additionalneeds,"Dinner");
		log.info("Verified that after Update additionalneeds is dinner");
		log.info("Partially Updated the Booking");
		test.log(Status.INFO,"Booking Updated Partially");
	}

	@Test(priority=5)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Delete booking")
	@Story("Delete Booking")
	public void deletebooking() {
		test=extent.createTest("Delete Booking");
		Response response=E_Delete_Booking_DELETE.deletebooking(BookingID, token);
		Assert.assertEquals(response.statusCode(),201);
		log.info("Verified that Status code is 201");
		Assert.assertEquals(response.statusLine(),"HTTP/1.1 201 Created");
		log.info("Verified that Status line is HTTP/1.1 201 Created");
		log.info("Deleted the Booking");
		log.info("All the Requests done");
		test.log(Status.INFO,"Booking Deleted");
		log.info("Test execution completed. Extent Report generated.");
		log.info("Allure Reports Generated");
	}

	@AfterClass
	public void tearDown() {
		extent.flush();
		log.info("Extent Report flushed successfully.");
	}
}
