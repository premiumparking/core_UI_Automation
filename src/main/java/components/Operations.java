package components;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.SPA.SPA_LocationPage;
import pageObjects.TextPay.TextPay_HomePage;
import reports.Extent_Reports;

public class Operations extends Extent_Reports {

	/*
	 * This method is to enter text into TEXTBOX
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void enterText(By ele, String text, String field) {
		waitForElementTobeClickable(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			element.clear();
			element.sendKeys(text);
			waitForPageLoad(1);
			passStep("Entered '" + text + "' into " + field);
		}
	}

	/*
	 * This method is to enter text into TEXTBOX using JSE
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void enterText_with_JSE(By ele, String text, String field) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);

			JavascriptExecutor jse = (JavascriptExecutor) BaseClass.driver;

			jse.executeScript("arguments[0].value='" + text + "';", element);

			// jse.executeScript("document.getElementById('pass').value = 'mukeshotwani';");
			element.clear();
			element.sendKeys(text);
			waitForPageLoad(1);
			passStep("Entered '" + text + "' into " + field);
		}
	}

	/*
	 * This method is to enter text into TEXTBOX but won't include in the report
	 * 
	 * Ex: username, password
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void enterText(By ele, String text) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			element.clear();
			element.sendKeys(text);
			waitForPageLoad(1);
			// passStep("Entered '" + text + "' into " + field);
		}
	}

	/*
	 * This method is to click on BUTTON
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void clickOnButton(By ele, String field) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		waitForPageLoad(1);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			element.click();
			passStep("Clicked on " + field);
			waitForPageLoad(2);
		}

	}

	/*
	 * This method is to click on BUTTON
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void clickOnButton(By ele) {
		waitForElementTobeClickable(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		waitForPageLoad(1);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			element.click();
			waitForPageLoad(2);
		}

	}

	/*
	 * This method is to click on BUTTON
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void clickOnButton_using_Actions(By ele, String field) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		waitForPageLoad(1);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			Actions act = new Actions(BaseClass.driver);
			act.moveToElement(BaseClass.driver.findElement(ele)).click().perform();
			// element.click();
			passStep("Clicked on " + field);
			waitForPageLoad(2);
		}

	}

	/*
	 * This method is to click on BUTTON
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void clickOnButton_using_JSE(By ele, String field) {

		//waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		waitForPageLoad(1);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
			js.executeScript("arguments[0].click();", BaseClass.driver.findElement(ele));
			passStep("Clicked on " + field);
			waitForPageLoad(2);
		}

	}

	/*
	 * This method is to verify whether the element is DISPLAYED or NOT and will
	 * include in the report
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public Boolean isElementDisplayed(By ele, String field) {
		WebElement element = BaseClass.driver.findElement(ele);
		waitForElementTobeDisplayed(ele);
		if (element.isDisplayed()) {
			passStep("'" + field + "' is displayed");
			return true;
		}
		return false;
	}

	/*
	 * This method is to verify whether the element is ENABLED or NOT and will
	 * include in the report
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public Boolean isElementEnabled(By ele, String field) {
		WebElement element = BaseClass.driver.findElement(ele);
		waitForElementTobeDisplayed(ele);
		if (element.isEnabled()) {
			passStep("'" + field + "' is enabled");
			return true;
		}
		return false;
	}

	/*
	 * This method is to verify whether the element is DISPLAYED or NOT
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public Boolean isElementDisplayed(By element) {
		WebElement ele = BaseClass.driver.findElement(element);
		highlightElement(ele);
		return ele.isDisplayed();

	}

	/*
	 * This method is to verify whether the element is ENABLED or NOT
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public Boolean isElementEnabled(By element) {
		return BaseClass.driver.findElement(element).isEnabled();

	}

	/*
	 * This method is to select RADIO BUTTON
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void select_Radiobutton(By ele, String field) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele, field) && element.isEnabled()) {
			highlightElement(element);
			if (element.isSelected()) {
				passStep(field + " is already selected");
			} else {
				element.click();
				passStep(field + " is selected");
			}
		}
	}

	/*
	 * This method is to select CHECKBOX
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void select_Checkbox(By ele, String field) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele, field) && element.isEnabled()) {
			highlightElement(element);
			if (element.isSelected()) {
				passStep(field + " is already selected");
			} else {
				element.click();
				passStep(field + " is selected");
			}
		}
	}

	/*
	 * This method is to UNselect CHECKBOX
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void unselect_Checkbox(By ele, String field) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele, field) && element.isEnabled()) {
			highlightElement(element);
			if (element.isSelected()) {
				element.click();
				passStep(field + " is unselected");
			} else {
				passStep(field + " is already uselected");
			}
		}
	}

	/*
	 * This method is to select DROPDOWN based on the text
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void selectDropdown(By ele, String text, String field) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (element.isDisplayed() && element.isEnabled()) {
			highlightElement(element);
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(text);
			passStep("Selected '" + text + "' from '" + field + "'");
		}
	}

	/*
	 * This method is to HIGHLIGHT the webelement
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public static void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		// js.executeScript("arguments[0].setAttribute('style', 'background: #828383;
		// border: 3px solid red;');", element);
		js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');", element);
	}

	/*
	 * Usage :Explicit wait for the element to be displayed
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public void waitForElementTobeDisplayed(By locator) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/*
	 * Usage :Explicit wait for the element to be clickable
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public void waitForElementTobeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/*
	 * Usage : Force wait to hold the execution for the given specific time period
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public void waitForPageLoad(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Usage : To get the value of the element (Ex: Button name)
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public String getElementValue(By ele) {
		return BaseClass.driver.findElement(ele).getAttribute("value");
	}

	/*
	 * Usage : To get the value of the element (Ex: Text)
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public String getElementText(By ele) {
		return BaseClass.driver.findElement(ele).getText();
	}

	/*
	 * This method is to select the search result on the search box
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void selectFromSearch(By ele, String text, String field) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			// element.clear();
			element.sendKeys(text);
			element.sendKeys(Keys.ARROW_DOWN);
			waitForPageLoad(1);
			element.sendKeys(Keys.ENTER);
			passStep("Selected  '" + text + "' on the " + field);
		}
	}

	/*
	 * This method is to select the dynamic value on the dropdown
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void select_FromDropDown(String text) {
		By value = By.xpath(".//li[@data-value='" + text + "']");
		clickOnButton(value, text);
	}

	/*
	 * This method is to move to the specific element
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void moveToElement(By ele) {
		WebElement element = BaseClass.driver.findElement(ele);
		Actions actions = new Actions(BaseClass.driver);
		actions.moveToElement(element);
	}

	/*
	 * This method is to accept the windows alert
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void acceptAlert() {
		BaseClass.driver.switchTo().alert().accept();
	}

	/*
	 * This method is to click an element but not include in the report
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void performClick(By ele) {
		WebElement element = BaseClass.driver.findElement(ele);
		element.click();
	}

	/*
	 * This method is to hit the enter key
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void hitEnter(By ele) {
		WebElement element = BaseClass.driver.findElement(ele);
		element.sendKeys(Keys.ENTER);
	}

	/*
	 * This method is click based on x,y coordinates
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void clickWithPoints(By ele) {
		WebElement element = BaseClass.driver.findElement(ele);
		// Used points class to get x and y coordinates of element.
		Point point = element.getLocation();
		int xcord = point.getX();
		int ycord = point.getY();

		// Using Actions class
		Actions action = new Actions(BaseClass.driver);

		// clicking on the element based on x coordinate and y coordinate
		action.moveToElement(element, xcord, ycord).click().build().perform();
	}

	/*
	 * This method is used to open new tab
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void openNewTab(String url) {
		// BaseClass.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +
		// "t");
		BaseClass.driver.switchTo().newWindow(WindowType.TAB);
		BaseClass.driver.get(url);
	}

	/*
	 * This method is used get all open tabs(windows)
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public ArrayList<String> getAllTabs() {
		return new ArrayList<String>(BaseClass.driver.getWindowHandles());
	}

	/*
	 * This method is used switch to the specific tab
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void switch_to_Tab(ArrayList<String> tabs, int number) {
		BaseClass.driver.switchTo().window(tabs.get(number));
	}

	/*
	 * This method is used close the specific tab
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void close_Tab(ArrayList<String> tabs, int number) {
		BaseClass.driver.switchTo().window(tabs.get(number)).close();
	}

	/*
	 * This method is used to the refresh the tab
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void refresh_Page() {
		BaseClass.driver.navigate().refresh();
	}

	/*
	 * This method is used to the switch iFrame
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void switchToIframe(By ele) {
		WebElement iframe = BaseClass.driver.findElement(ele);
		BaseClass.driver.switchTo().frame(iframe);
	}

	/*
	 * This method is used to choose time on timebar
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void changeTimeBar(String id, String time) {
		JavascriptExecutor jse = (JavascriptExecutor) BaseClass.driver;

		// jse.executeScript("arguments[0].value='" + time + "';", element);
		jse.executeScript("document.getElementById('" + id + "').value='" + time + "'");
	}

	/*
	 * This method is used to choose time on timebar
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void changeTime(String time) {
		TextPay_HomePage tph = new TextPay_HomePage();
		WebElement timeBar = BaseClass.driver.findElement(tph.duration_Bar);
		// WebElement Telement = BaseClass.driver.findElement(to);
		Actions act = new Actions(BaseClass.driver);

		int xOffset = timeBar.getLocation().getX();
		int yOffset = timeBar.getLocation().getY();

		if (time.equalsIgnoreCase("1"))
			xOffset = -500;
		else if (time.equalsIgnoreCase("2"))
			xOffset = -200;

		act.dragAndDropBy(timeBar, xOffset, yOffset).perform();
	}

	public void changeTimeSPA(String time) {
		SPA_LocationPage tph = new SPA_LocationPage();
		WebElement timeBar = BaseClass.driver.findElement(tph.duration_Bar);
		// WebElement element = BaseClass.driver.findElement(to);
		Actions act = new Actions(BaseClass.driver);

		int xOffset = timeBar.getLocation().getX();
		int yOffset = timeBar.getLocation().getY();

		if (time.equalsIgnoreCase("1"))
			yOffset = -500;

		act.dragAndDropBy(timeBar, -xOffset, yOffset).perform();
	}

	public void scrollToElement(By ele) {

		WebElement element = BaseClass.driver.findElement(ele);

		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", element);
		passStep("Scrolled down to  " + element.getText());
	}
}
