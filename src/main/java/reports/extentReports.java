package reports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.loadXMLData;

public class extentReports extends loadXMLData{

	protected static ExtentTest test;
	public static ExtentReports report;

	  
	  
	
	@BeforeSuite
	public static void startTest() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String d = dateFormat.format(date).toString();
		String timeStamp = new SimpleDateFormat("HHmmss").format(new Date());
		String reportName = "ExtentReport_" + timeStamp;

		report = new ExtentReports(
				System.getProperty("user.dir") + "\\TestResults\\" + d + "\\" + reportName + ".html");
		
		report       
        .addSystemInfo("Environment", "QA")
        .addSystemInfo("User Name", "Venu Thota (venu.t@comakeit.com)");
		
		

	}

	@AfterMethod
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}
	
	
	public void passStep(String stepinfo)
	{
		test.log(LogStatus.PASS, stepinfo);
	}
	
	public void failStep(String stepinfo)
	{
		test.log(LogStatus.FAIL, stepinfo);
	}
	
	public void stepInfo(String stepinfo)
	{
		test.log(LogStatus.INFO, stepinfo);
	}
}
