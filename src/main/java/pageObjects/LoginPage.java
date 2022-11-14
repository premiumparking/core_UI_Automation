package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import components.BaseClass;

public class LoginPage extends BaseClass {

	HomePage homePage;

	public WebElement textBox_Username() {
		return driver.findElement(By.id("loginUsername"));

	}

	public WebElement button_SignIn() {
		return driver.findElement(By.xpath(".//button[@data-cy=\"test-signin\"]"));

	}

	public WebElement textBox_userName() {
		return driver.findElement(By.xpath(".//input[@data-cy='test-email-input']"));
	}

	public WebElement button_Submit() {
		return driver.findElement(By.xpath(".//button[@data-cy='submit-btn']"));

	}

	public WebElement textBox_password() {
		return driver.findElement(By.xpath(".//input[@data-cy='test-password-input']"));
	}

	public WebElement pp_logo() {
		return driver.findElement(By.xpath(".//span[@data-testid='test-full-logo']"));
	}

	public WebElement link_Profile() {
		return driver.findElement(By.xpath(".//span[@data-cy='nav-dropdown-login']"));

	}

	public void login() {
		waitForPageLoad(5);
		clickOnButton(button_SignIn(), "Sign In");
		waitForPageLoad(3);
		enterText(textBox_userName(), "premiumparkingqa@gmail.com", "User Name");
		clickOnButton(button_Submit(), "Next");
		waitForPageLoad(3);
		enterText(textBox_password(), "9010030500", "Password");
		clickOnButton(button_Submit(), "Next");
		waitForPageLoad(3);
	}

	public void loginIncorrectly() {
		waitForPageLoad(5);
		clickOnButton(button_SignIn(), "Sign In");
		waitForPageLoad(3);
		enterText(textBox_userName(), "premiumparkingqa@gmail.com", "User Name");
		clickOnButton(button_Submit(), "Next");
		waitForPageLoad(3);
		enterText(textBox_password(), "3145564", "Password");
		clickOnButton(button_Submit(), "Next");
		waitForPageLoad(3);
		isElementDisplayed(link_Profile(), "Profile Name");
	}

}
