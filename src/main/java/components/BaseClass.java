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
import pageObjects.OD.OD_LoginPage;
import pageObjects.SPA.SPA_AccountsPage;
import pageObjects.SPA.SPA_LoginPage;
import pageObjects.TextPay.TextPay_HomePage;

public class BaseClass extends Operations {

	protected static String profilesURL = null;
	protected static String businessAccountURL = null;
	Properties config;
	FileInputStream fis;
	public static WebDriver driver;
	protected static String adm_username, adm_password, adm_url;
	protected static String od_username, od_password, od_url;
	protected static String spa_url, spa_username, spa_password;
	protected static String textpay_url;
	protected String headless;
	protected String browser;
	SPA_LoginPage spaLoginPage;
	SPA_AccountsPage accountsPage;

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
		// OD Configurations
		od_url = config.getProperty("od_url");
		od_username = config.getProperty("od_username");
		od_password = config.getProperty("od_password");

		profilesURL = config.getProperty("url_new_profile");
		businessAccountURL = config.getProperty("url_businessaccounts");

		// Admiral Enforcement Web Configurations
		adm_url = config.getProperty("adm_url");
		adm_username = config.getProperty("adm_username");
		adm_password = config.getProperty("adm_password");

		// Browser Configurations
		browser = config.getProperty("browser");
		this.headless = config.getProperty("headless");

		// SPA Configurations
		spa_url = config.getProperty("spa_url");
		spa_username = config.getProperty("spa_username");
		spa_password = config.getProperty("spa_password");

		// TextPay configurations
		textpay_url = config.getProperty("textpay_url");
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

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions ch_options = new ChromeOptions();

			if (Boolean.parseBoolean(headless))
				ch_options.addArguments("--headless");

			ch_options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(ch_options);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions ff_options = new FirefoxOptions();

			if (Boolean.parseBoolean(headless))
				ff_options.addArguments("--headless");
			ff_options.addArguments("--remote-allow-origins=*");
			driver = new FirefoxDriver(ff_options);

			break;
		default:
			WebDriverManager.edgedriver().setup();
			EdgeOptions ed_options = new EdgeOptions();
			if (Boolean.parseBoolean(headless))
				ed_options.addArguments("--headless");

			ed_options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(ed_options);
			break;

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

		return "<span style='color:#d64161;'>" + className + " : </span> " + "<span style='color:#4040a1;'>"
				+ testMethod.getName() + " : </span> ";
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
	 * Usage : To launch application & Returns : OD_LoginPage
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public OD_LoginPage launch_OD_Application() {
		driver.get(od_url);
		OD_LoginPage loginPage = new OD_LoginPage();
		waitForElementTobeDisplayed(loginPage.textbox_UserName);
		if (isElementDisplayed(loginPage.textbox_UserName)) {
			passStep("Launched OD application <b>" + od_url + "</b>");
		}
		return loginPage;
	}

	/*
	 * Usage : To launch application & Returns : SPA_LoginPage
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public SPA_LoginPage launch_SPA_Application() {
		driver.get(spa_url);
		SPA_LoginPage spaLoginPage = new SPA_LoginPage();
		waitForElementTobeDisplayed(spaLoginPage.button_SignIn);
		if (isElementDisplayed(spaLoginPage.button_SignIn)) {
			passStep("Launched SPA application <b>" + spa_url + "</b>");
		}
		return spaLoginPage;
	}

	/*
	 * Usage : To launch application & Returns : Adm_LoginPage
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
	 * Usage : To launch TextPay application
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public TextPay_HomePage launch_TextPay_Application() {
		driver.get(textpay_url);
		TextPay_HomePage tp_homePage = new TextPay_HomePage();
		waitForElementTobeDisplayed(tp_homePage.link_Guest);
		if (isElementDisplayed(tp_homePage.link_Guest))
			passStep("Launched the Textpay application <b>" + textpay_url + "</b>");
		return tp_homePage;
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
			stepInfo("<i>__Failed due to below exception__ :</i> ");
			failStep(result.getThrowable().toString());
			String screenshotPath = BaseClass.getScreenshot(driver, result.getName());

			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));

		}
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

	/*
	 * Usage : To generate 5 digit random licence plate which is used purchase a
	 * space
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public String getRandomLicencePlate() {
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		char letter1 = abc.charAt(random.nextInt(abc.length()));
		char letter2 = abc.charAt(random.nextInt(abc.length()));
		return letter1 + "" + String.format("%03d", random.nextInt(1000)).concat(letter2 + "");
	}

	/*
	 * Usage : To generate random promo code
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public String getRandomPromoCode() {
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		char letter1 = abc.charAt(random.nextInt(abc.length()));
		char letter2 = abc.charAt(random.nextInt(abc.length()));
		return letter1 + "" + String.format("%05d", random.nextInt(1000)).concat(letter2 + "");
	}

	/*
	 * Usage : To generate random phone number
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public String getRandomPhoneNumber() {
		Random random = new Random();
		return String.format("%010d", random.nextInt(1000));
	}

	/*
	 * Usage : To generate random number
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public String getRandomNumber() {
		Random random = new Random();
		return String.format("%02d", random.nextInt(100));
	}

	/*
	 * Usage : To get random location from list of Locations space
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public String getRandomLocation() {

		String[] locations = Constants.LOCATIONS;
		Random random = new Random();
		int index = random.nextInt(locations.length);

		return locations[index];
	}
	
	
	/*
	 * Usage : To get random location from list of Locations space
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public String Add_NewVehicle() {
		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		return accountsPage.add_New_Vehicle();
	}

}
