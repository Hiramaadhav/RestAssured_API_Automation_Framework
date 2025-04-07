package Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utils.Extent_Report_Manager;
import io.restassured.RestAssured;

public class Base_Class {

	public static String token;
	public static Logger log = LogManager.getLogger(Base_Class.class);
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void setup() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		token=Utils.Auth_Token_Generator.get_token();
		extent = Extent_Report_Manager.initReport();
	}
}
