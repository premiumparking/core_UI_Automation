package components;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import reports.Extent_Reports;

public class Operations extends Extent_Reports {

	/*
	 * This method is to enter text into TEXTBOX
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void enterText(By ele, String text, String field) {
		waitForElementTobeDisplayed(ele);
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
	public void clickOnButton_using_Actions(By ele, String field) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		waitForPageLoad(1);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			Actions act =  new Actions(BaseClass.driver);
			act.moveToElement(BaseClass.driver.findElement(ele)).click().perform();
			//element.click();
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
		return BaseClass.driver.findElement(element).isDisplayed();

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
	public void selectRadiobutton(By ele, String field) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele, field) && element.isEnabled()) {
			highlightElement(element);
			if (element.isSelected()) {
				passStep(field + "' is already selected");
			} else {
				element.click();
				passStep(field + "' is selected");
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
		js.executeScript("arguments[0].setAttribute('style', 'background: #90ee90; border: 2px solid yellow;');",
				element);
	}

	/*
	 * Usage :Explicit wait for the element to be displayed
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public void waitForElementTobeDisplayed(By locator) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
			element.clear();
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
}

