package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Report_Manager {

	private static ExtentReports extent;

	public static ExtentReports initReport() {
		if (extent == null) {
			String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			String reportPath = System.getProperty("user.dir") + "/Reports/ExtentReport_" + timestamp + ".html";

			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
			sparkReporter.config().setReportName("RestAssured API Automation Report");
			sparkReporter.config().setDocumentTitle("Restful Booker API Report");
			sparkReporter.config().setTheme(Theme.DARK);

			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Framework", "RestAssured");
			extent.setSystemInfo("Tester", "Maadhav Hira");
			extent.setSystemInfo("Environment", "QA");
		}
		return extent;
	}
}
