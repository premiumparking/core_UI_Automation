package components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import reports.extentReports;

public class Operations extends extentReports {

	public void enterText(WebElement element, String text, String field) {
		if (isElementDisplayed(element, field) && element.isEnabled()) {
			BaseClass.highlightElement(element);
			element.clear();
			element.sendKeys(text);
			passStep("Entered Text '" + text + "' into textbox '" + field + "'");
		}

	}

	public void clickOnButton(WebElement element, String field) {
		if (isElementDisplayed(element, field) && element.isEnabled()) {
			BaseClass.highlightElement(element);
			element.click();
			passStep("Clicked '" + field + "' button");
		}
	}

	public void clickOnName(WebElement element, String field) {
		if (isElementDisplayed(element, field) && element.isEnabled()) {
			BaseClass.highlightElement(element);
			element.click();
			passStep("Clicked '" + field + "' link text");
		}
	}

	public Boolean isElementDisplayed(WebElement element, String field) {
		Boolean status = false;
		try {
			if (element.isDisplayed()) {
				passStep("'" + field + "' is displayed");
				status = true;
			}
		} catch (Exception ex) {
			failStep("'" + field + "' is NOT displayed due to below exception");
			failStep(ex.getMessage());
			status = false;

		}
		return status;
	}

	public Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();

	}

	public void selectRadiobutton(WebElement element, String field) {
		if (isElementDisplayed(element, field) && element.isEnabled()) {
			if (element.isSelected()) {
				passStep("Radio Button '" + field + "' is already selected");
			} else {
				try {
					BaseClass.highlightElement(element);
					element.click();
					passStep("Radio Button of '" + field + "' is selected");
				} catch (Exception ex) {
					failStep("Unable to select the Radio box '" + field + "' due to below exception");
					failStep(ex.getMessage());
				}
			}
		}
	}

	public void selectDropdown(WebElement element, String text, String field) {
		if (element.isDisplayed() && element.isEnabled()) {
			try {
				BaseClass.highlightElement(element);
				Select dropdown = new Select(element);
				dropdown.selectByVisibleText(text);
				passStep("Selected dropdown value '" + text + "' from '" + field + "'");
			} catch (Exception ex) {
				failStep("Unable to select the dropdown value from '" + field + "' due to below exception");
				failStep(ex.getMessage());
			}

		}
	}

}
