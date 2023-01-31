package pageObjects.OD;

import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs static page group activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_StaticPageGroupsPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_StaticPageGroup = By.xpath("//h2[contains(text(),'Static Page Groups')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_New_staticPageGroup = By.xpath("//h1[contains(text(),'New Static Page Group')]");
    By textBox_SPGTitle = By.id("static_page_group_title");
    By textBox_SPGSlug = By.id("static_page_group_slug");
    By button_save = By.xpath("//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new static page group
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_staticPageGroup(String title, String slug) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_New_staticPageGroup);
        enterText(textBox_SPGTitle, title, " Static Page Group Title Textbox");
        enterText(textBox_SPGSlug, slug, "Static Page Group Slug Textbox");
        clickOnButton(button_save, "Save Button");

        By staticPageGroupTitleOnGrid = By.xpath("//td[contains(text(),'" + title + "')]");
        waitForElementTobeDisplayed(staticPageGroupTitleOnGrid);
        if (isElementDisplayed(staticPageGroupTitleOnGrid)) {
            passStep("Static Page Group " + title + " has been displayed on grid");
            passStep("Static Page Group creation is successful ...!!!");
        }

    }
}
