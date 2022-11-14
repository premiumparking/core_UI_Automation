package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import components.BaseClass;

public class HomePage extends BaseClass {

	public WebElement mainMenu_Home() {
		return driver.findElement(By.id("mainmenu-home"));
	}

	public WebElement mainMenu_Management() {
		return driver.findElement(By.id("mainmenu-management"));
	}

	public WebElement mainMenu_Workspaces() {
		return driver.findElement(By.id("mainmenu-workspaces"));
	}

	public WebElement mainMenu_Marketplace() {
		return driver.findElement(By.id("mainmenu-marketplace"));
	}

	public WebElement subMenu_Location() {
		return driver.findElement(By.id("submenu-location"));
	}




	public LocationManagementPage navigateToLocationManagement() {
		waitForPageLoad(2);
		clickOnButton(mainMenu_Management(), "Management menu");
		waitForPageLoad(1);
		clickOnButton(subMenu_Location(), "Location sub-menu");
		waitForPageLoad(2);

		return new LocationManagementPage();

	}



}
