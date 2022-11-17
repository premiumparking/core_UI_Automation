package components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProfilesPage;

public class BaseClass extends Operations {

	String appplicationUrl = null;
	Properties config;
	FileInputStream fis;
	public static WebDriver driver = null;
	protected static HomePage homePage;
	protected static LoginPage loginPage;
	protected static ProfilesPage profilePage;
	protected static String username, password;

	/*
	 * This method is to load data from application.properties files
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public void loadProperties() throws IOException {

		config = new Properties();
		String fpath = System.getProperty("user.dir") + "\\src\\test\\resources\\application.properties";
		fis = new FileInputStream(fpath);

		config.load(fis);
		appplicationUrl = config.getProperty("url");
		username = config.getProperty("username");
		password = config.getProperty("password");

	}

	/*
	 * This method is to launch the browser
	 * 
	 * @BeforeMethod : annotation to invoke before the execution of each test method
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	@BeforeMethod(alwaysRun = true)
	public void launchBrowser(Method testMethod) throws InterruptedException, IOException {

		loadProperties();
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test = report.startTest(getTestCaseName(testMethod));
		report.addSystemInfo("Browser", "Chrome");
		waitForPageLoad(1);

	}

	/*
	 * Usage: to get the test case name to include in the reports
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public String getTestCaseName(Method testMethod) {

		String name = testMethod.getDeclaringClass().getTypeName();
		String className = name.substring(name.lastIndexOf(".") + 1);

		return "<span style=\"color:blue;\">" + className + " : </span> " + testMethod.getName();

	}

	/*
	 * Usage : To get the current timestamp
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public String getTimestamp() {
		return new SimpleDateFormat("HHmmss").format(new Date());
	}

	/*
	 * Usage : To launch application & Returns : LoginPage
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public LoginPage launchApplication() {
		driver.get(appplicationUrl);
		passStep("Launched the application <b>" + appplicationUrl + "</b>");
		loginPage = new LoginPage();
		return loginPage;
	}

	/*
	 * Usage : This method is to quit the browser
	 * 
	 * @AfterMethod : annotation to invoke after the execution of each test method
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	@AfterMethod(alwaysRun = true)
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}

	/*
	 * Usage : This method is to get the screenshots of the web page
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String d = dateFormat.format(date).toString();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("HHmmss").format(new Date());
		String screenshot = "Failure_" + timeStamp;
		String destination = System.getProperty("user.dir") + "\\TestResults\\" + d + "\\" + screenshot + ".png";

		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	/*
	 * Usage : This method is to quit the browser
	 * 
	 * @AfterMethod : annotation to invoke after the execution of each test method
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			stepInfo("Failed Due to below exception : ");
			failStep(result.getThrowable().toString());
			String screenshotPath = BaseClass.getScreenshot(driver, result.getName());

			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));

		}
	}

}
