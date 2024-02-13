package components;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.batik.util.XMLResourceDescriptor;
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
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.github.javafaker.Faker;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Admiral.Adm_LoginPage;
import pageObjects.OD.OD_HomePage;
import pageObjects.OD.OD_LocationsPage;
import pageObjects.OD.OD_LoginPage;
import pageObjects.SPA.SPA_AccountsPage;
import pageObjects.SPA.SPA_LoginPage;
import pageObjects.TextPay.TextPay_HomePage;
import utils.Email_Verification;

public class BaseClass extends Operations {

	protected static String profilesURL = null;
	protected static String businessAccountURL = null;
	Properties config;
	FileInputStream fis;
	public static WebDriver driver;
	protected static String adm_username, adm_password, adm_url;
	protected static String od_username, od_password, od_url;
	protected static String spa_url, spa_username, spa_password;
	protected static String textpay_url, yopmail_url;
	protected static String headless, browser, yopmail, mailosaur_apiKey, mailosaur_serverId, mailosaur_serverDomain;
	public static String os;
	SPA_LoginPage spaLoginPage;
	SPA_AccountsPage accountsPage;

	/*
	 * This method is to load data from application.properties files
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public void loadProperties() throws IOException {

		config = new Properties();
		String fpath = System.getProperty("user.dir") + "//src//test//resources//application.properties";
		// String fpath = System.getProperty("user.dir") +
		// "\\src\\test\\resources\\application.properties";
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
		headless = config.getProperty("headless");
		os = config.getProperty("os");
		yopmail = config.getProperty("yopmail");

		// SPA Configurations
		spa_url = config.getProperty("spa_url");
		spa_username = config.getProperty("spa_username");
		spa_password = config.getProperty("spa_password");

		// TextPay configurations
		textpay_url = config.getProperty("textpay_url");

		// yopmail
		yopmail_url = config.getProperty("yopmail_url");

		mailosaur_apiKey = config.getProperty("mailosaur_apiKey");
		mailosaur_serverId = config.getProperty("mailosaur_serverId");
		mailosaur_serverDomain = config.getProperty("mailosaur_serverDomain");

	}

	/*
	 * This method is to launch the browser
	 *
	 * @BeforeMethod : annotation to invoke before the execution of each test method
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	@BeforeMethod(alwaysRun = true)
	public void launchBrowser(Method testMethod) throws InterruptedException, IOException {

		loadProperties();

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			WebDriverManager.chromedriver().getDownloadedDriverVersion();
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

		test = report.startTest(getTestSuiteName(testMethod));
		report.addSystemInfo("Browser", browser);
		stepInfo("Test <i><b>" + getTestCaseName(testMethod, "pass") + "</b></i>Started");
		waitForPageLoad(1);

	}

	/*
	 * Usage: to get the test SUite name to include in the reports
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public String getTestSuiteName(Method testMethod) {

		String name = testMethod.getDeclaringClass().getTypeName();
		String className = name.substring(name.lastIndexOf(".") + 1);

		return "<span style='color:#d64161;'>" + className + " : </span> " + "<span style='color:#4040a1;'>"
				+ testMethod.getName() + " : </span> ";
	}

	/*
	 * Usage: to get the test case name to include in the reports
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public String getTestCaseName(Method testMethod, String status) {
		String testcaseName = null;
		if (status.equalsIgnoreCase("pass"))
			testcaseName = "<span style='color:#32CD32;'>" + testMethod.getName() + " : </span> ";
		else if (status.equalsIgnoreCase("fail"))
			testcaseName = "<span style='color:#ff0000;'>" + testMethod.getName() + " : </span> ";
		else if (status.equalsIgnoreCase("skip"))
			testcaseName = "<span style='color:#005CD2;'>" + testMethod.getName() + " : </span> ";
		return testcaseName;
	}

	/*
	 * Usage : To get the current timestamp
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public String getTimestamp() {
		return new SimpleDateFormat("HHmmss").format(new Date());
	}

	/*
	 * Usage : To launch application & Returns : OD_LoginPage
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
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
	 * Author : Venu Thota (venu.thota@xebia.com)
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
	 * Author : Venu Thota (venu.thota@xebia.com)
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
	 * Usage : To launch TextPay application
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public TextPay_HomePage launch_TextPay_Application_withLocation_QR_code() throws TranscoderException {
		OD_LoginPage od_loginPage = new OD_LoginPage();
		OD_HomePage od_homePage = new OD_HomePage();
		OD_LocationsPage od_locationsPage = new OD_LocationsPage();

		od_loginPage = launch_OD_Application();
		od_homePage = od_loginPage.login();
		od_locationsPage = od_homePage.navigateToLocationsPage();
		String url = od_locationsPage.scan_Location_QR_code(getRandomLocation());
		Assert.assertTrue(!url.isEmpty(), "Failed to convert QR code into URL");
		passStep("QR code URL is <b>" + url + "</b>");
		openNewTab(url);
		TextPay_HomePage tp_homePage = new TextPay_HomePage();
		waitForElementTobeDisplayed(tp_homePage.link_Guest);
		if (isElementDisplayed(tp_homePage.link_Guest))
			passStep("Launched the Textpay application <b>" + url + "</b> from the QR code");
		return tp_homePage;
	}

	/*
	 * Usage : This method is to quit the browser
	 *
	 * @AfterMethod : annotation to invoke after the execution of each test method
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	@AfterMethod(alwaysRun = true)
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}

	/*
	 * Usage : This method is to get the screenshots of the web page
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String d = dateFormat.format(date).toString();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("HHmmss").format(new Date());
		String screenshot = "Failure_" + timeStamp;
		String destination = System.getProperty("user.dir") + "//TestResults//" + d + "//" + screenshot + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	/*
	 * Usage : This method is to quit the browser
	 *
	 * @AfterMethod : annotation to invoke after the execution of each test method
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result, Method testMethod) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			stepInfo("<i>__Failed due to below exception__ :</i> ");
			failStep(result.getThrowable().toString());
			String screenshotPath = BaseClass.getScreenshot(driver, result.getName());

			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
			stepInfo("Test <i><b>" + getTestCaseName(testMethod, "fail") + "</b></i> Failed");

		} else if (result.getStatus() == ITestResult.SUCCESS)
			stepInfo("Test <i><b>" + getTestCaseName(testMethod, "pass") + "</b></i> Passed");

		else if (result.getStatus() == ITestResult.SKIP)
			stepInfo("Test  <i><b>" + getTestCaseName(testMethod, "skip") + "</b></i> Skipped");
	}

	/*
	 * Usage : To generate 4 digit random number which is used as a location number
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public String get4DigitRandomNumber() {
		Random random = new Random();
		return String.format("%04d", random.nextInt(10000));
	}

	/*
	 * Usage : To generate 5 digit random licence plate which is used purchase a
	 * space
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
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
	 * Author : Venu Thota (venu.thota@xebia.com)
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
	 * Author : Venu Thota (venu.thota@xebia.com)
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
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public String getRandomLocation() {

		String[] locations = Constants.LOCATIONS;
		Random random = new Random();
		int index = random.nextInt(locations.length);

		return locations[index];
	}

	/*
	 * Usage : To get random PEEK location from list of Locations space
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public String getRandom_PEEK_Location() {

		String[] locations = Constants.PEEK_LOCATIONS;
		Random random = new Random();
		int index = random.nextInt(locations.length);

		return locations[index];
	}

	/*
	 * Usage : To get random location from list of Locations space
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public String Add_NewVehicle() {
		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		return accountsPage.add_New_Vehicle();
	}

	/*
	 * Usage : To get random US Phone number from list of US Phone numbers
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public String getRandomUSPhoneNumber() {

		String[] us_ph_numbers = Constants.US_PHONE_NUMBERS;
		Random random = new Random();
		int index = random.nextInt(us_ph_numbers.length);

		return us_ph_numbers[index];
	}

	/*
	 * Usage : To launch Yopmail application
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public Email_Verification launch_yopmail() {
		// driver.get(yopmail_url);
		openNewTab(yopmail_url);
		Email_Verification emailPage = new Email_Verification();
		waitForElementTobeDisplayed(emailPage.textBox_Email);
		if (isElementDisplayed(emailPage.textBox_Email))
			passStep("Launched the Yopmail mailbox page");
		return emailPage;
	}

	/*
	 * Usage : To generate random promo code
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public String getRandomYopmailAddress() {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 5; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}

		return sb.toString() + "_" + getTimestamp() + "@yopmail.com";

	}

	/*
	 * Usage : To generate unique fake name
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public String getFakeName() {
		Faker faker = new Faker();
		return faker.name().firstName() + "_" + getTimestamp();

	}

	/*
	 * Usage : To generate random Vehicle make from list of Makes
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public String getRandom_Vehicle_Make() {
		String[] vehicle_makes = Constants.VEHICLE_MAKE;
		Random random = new Random();
		int index = random.nextInt(vehicle_makes.length);

		return vehicle_makes[index];
	}

	/*
	 * Usage : To generate random Vehicle color from list of Colors
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public String getRandom_Vehicle_Color() {
		String[] vehicle_colors = Constants.VEHICLE_COLOR;
		Random random = new Random();
		int index = random.nextInt(vehicle_colors.length);

		return vehicle_colors[index];
	}

	/*
	 * Usage : To generate random Vehicle Type from list of Types
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public String getRandom_Vehicle_Type() {
		String[] vehicle_types = Constants.VEHICLE_TYPE;
		Random random = new Random();
		int index = random.nextInt(vehicle_types.length);

		return vehicle_types[index];
	}

	/*
	 * Usage : To convert QR code of format SVG into the URL. It converts .svg to
	 * .png and decodes the URL
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public static String readQRCodeFromSVG(String svgUrl) {
		try {
			// Create a Document from the SVG file
			String parser = XMLResourceDescriptor.getXMLParserClassName();
			SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);

			File pngFile = File.createTempFile("qr_code", ".png");
			PNGTranscoder transcoder = new PNGTranscoder();
			TranscoderInput input = new TranscoderInput(f.createDocument(svgUrl));
			try (FileOutputStream outputStream = new FileOutputStream(pngFile)) {
				TranscoderOutput output = new TranscoderOutput(outputStream);
				transcoder.transcode(input, output);
			}

			// Decode QR code from PNG
			return decodeQRCode(pngFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Usage : To decode the QR code of format .png file
	 *
	 * Author : Venu Thota (venu.thota@xebia.com)
	 */
	public static String decodeQRCode(File pngFile) {
		try {
			BufferedImage bufferedImage = ImageIO.read(pngFile);
			BinaryBitmap bitmap = new BinaryBitmap(
					new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
			Map<DecodeHintType, Object> hints = new HashMap<>();
			hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
			Result result = new MultiFormatReader().decode(bitmap, hints);
			return result.getText();
		} catch (NotFoundException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
