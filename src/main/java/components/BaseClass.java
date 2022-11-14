package components;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class BaseClass extends Operations {

	String appplicationUrl = null;
	Properties config;
	FileInputStream fis;
	public static WebDriver driver = null;
	protected static HomePage homePage;
	protected static LoginPage loginPage;

	/*
	 * Usage : This method is to load data from application.properties files Author
	 * : Venu Thota
	 */
	public void loadProperties() throws IOException {

		config = new Properties();
		String fpath = System.getProperty("user.dir") + "\\src\\test\\resources\\application.properties";
		fis = new FileInputStream(fpath);

		config.load(fis);
		appplicationUrl = config.getProperty("url");

	}

	/*
	 * Usage : This method is to launch the browser
	 * 
	 * @BeforeMethod : Method will be invoked before the execution of each test
	 * method where the test method is nothing but a test case Author : Venu Thota
	 */
	@BeforeMethod
	public void launchBrowser(Method testMethod) throws InterruptedException, IOException {

		loadProperties();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test = report.startTest(getTestCaseName(testMethod));
		report.addSystemInfo("Browser", "Chrome");
		waitForPageLoad(1);

	}

	public String getTestCaseName(Method testMethod) {

		String name = testMethod.getDeclaringClass().getTypeName();
		String className = name.substring(name.lastIndexOf(".") + 1);

		return "<span style=\"color:blue;\">" + className + " : </span> " + testMethod.getName();

	}

	/*
	 * Usage : To get the current timestamp Author : Venu Thota
	 */
	public String getTimestamp() {
		return new SimpleDateFormat("HHmmss").format(new Date());
	}

	public String get4DigitRandomNumber() {
		Random random = new Random();
		return String.format("%04d", random.nextInt(10000));
	}

	/*
	 * Usage : To launch application Author : Venu Thota Returns : LoginPage
	 */
	public LoginPage launchApplication1() {
		driver.get(appplicationUrl);
		passStep("Application " + appplicationUrl + " has been launched");
		loginPage = new LoginPage();
		return loginPage;
	}

	public HomePage launchApplication() {
		driver.get(appplicationUrl);
		waitForPageLoad(1);
		passStep("Application <b>" + appplicationUrl + "</b> has been launched");
		return new HomePage();
	}

	/*
	 * Usage : Execution will hold for the given specific time period Parameters :
	 * int Returns : Homepage Author : Venu Thota
	 */
	public void waitForPageLoad(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForElementTobeDisplayed(By locator) {		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
			

	/*
	 * Usage : This method is to quit the browser
	 * 
	 * @BeforeMethod : Method will be invoked after the execution of each test
	 * method where the test method is nothing but a test case Author : Venu Thota
	 */
	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}

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

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			stepInfo("Failed Due to below exception : ");
			failStep(result.getThrowable().toString());
			String screenshotPath = BaseClass.getScreenshot(driver, result.getName());

			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));

		}
	}

	public static void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: #90ee90; border: 2px solid yellow;');",
				element);
	}

}
