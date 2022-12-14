package components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Admiral.Adm_LoginPage;
import pageObjects.OD.HomePage;
import pageObjects.OD.LoginPage;
import pageObjects.OD.ProfilesPage;

public class BaseClass extends Operations {

	String appplicationUrl = null;
	String spa_applicationUrl = null;
	protected static String profilesURL = null;
	protected static String businessAccountURL = null;
	Properties config;
	FileInputStream fis;
	public static WebDriver driver = null;
	protected static HomePage homePage;
	// protected static LoginPage loginPage;
	protected static ProfilesPage profilePage;
	protected static String username, password, adm_username, adm_password, adm_url, browser, headless, spa_username, spa_password;

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
		profilesURL = config.getProperty("url_new_profile");
		businessAccountURL = config.getProperty("url_businessaccounts");
		username = config.getProperty("username");
		password = config.getProperty("password");
		adm_url = config.getProperty("adm_url");
		adm_username = config.getProperty("adm_username");
		adm_password = config.getProperty("adm_password");
		browser = config.getProperty("browser");
		headless = config.getProperty("headless");
		spa_applicationUrl = config.getProperty("spa_url");
		spa_username = config.getProperty("spa_username");
		spa_password = config.getProperty("spa_password");

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

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("headless");
			driver = new FirefoxDriver();

		}

		else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();

			EdgeOptions options = new EdgeOptions();
			options.addArguments("headless");
			driver = new EdgeDriver();

		}
		driver.manage().window().maximize();

		test = report.startTest(getTestCaseName(testMethod));
		report.addSystemInfo("Browser", browser);
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
		LoginPage loginPage = new LoginPage();
		waitForElementTobeDisplayed(loginPage.textbox_UserName);
		return loginPage;
	}

//	public spaLoginPage launchApplication() {
//		driver.get(appplicationUrl);
//		passStep("Launched the application <b>" + appplicationUrl + "</b>");
//		LoginPage loginPage = new LoginPage();
//		waitForElementTobeDisplayed(loginPage.textbox_UserName);
//		return loginPage;
//	}

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

	/*
	 * Usage : To launch application & Returns : LoginPage
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public Adm_LoginPage launch_AdmiralEnforcement_Application() {
		driver.get(adm_url);
		Adm_LoginPage loginPage = new Adm_LoginPage();
		waitForElementTobeDisplayed(loginPage.textbox_UserName);
		if (isElementDisplayed(loginPage.textbox_UserName))
			passStep("Launched the Admiral Enforcement application <b>" + adm_url + "</b>");
		return loginPage;
	}
	
	/*
	 * Usage : To generate 4 digit random number which is used as a location number
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public String get4DigitRandomNumber() {
		Random random = new Random();
		return String.format("%04d", random.nextInt(10000));
	}

}
