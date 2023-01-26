package pageObjects.OD;

import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs help page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_HelpPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_Helps = By.xpath("//h2[contains(text(),'Help/FAQ')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewHelp = By.xpath("//h1[contains(text(),'New Help')]");
    By textBox_helpTitle = By.id("help_title");
    By textBox_helpBody = By.xpath("//div[@contenteditable='true']//p");
    By button_save_help = By.xpath("//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new help request
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_HelpRequest(String title) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewHelp);
        enterText(textBox_helpTitle, title, " Help Title Textbox");
        enterText(textBox_helpBody, "Dummy Test Data", "Help Body Textbox");
        clickOnButton(button_save_help, "Save Button");

        By helpTitleOnGrid = By.xpath("//td[contains(text(),'" + title + "')]");
        waitForElementTobeDisplayed(helpTitleOnGrid);
        if (isElementDisplayed(helpTitleOnGrid)) {
            passStep("Help Title " + title + " has been displayed on grid");
            passStep("Help Request creation is successful ...!!!");
        }

    }
}
