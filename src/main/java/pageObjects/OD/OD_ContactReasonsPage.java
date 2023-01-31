package pageObjects.OD;

import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs contact reasons page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_ContactReasonsPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_ContactReasons = By.xpath("//h2[contains(text(),'Contact Reasons ')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewContactReasons = By.xpath("//h1[contains(text(),'New Contact Reason')]");
    By textBox_contactReasonLabel = By.id("contact_reason_label");
    By textBox_supportArticle = By.id("contact_reason_support_article_ids-selectized");
    By button_save = By.xpath("//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new contact reason
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_contactReason(String label) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewContactReasons);
        enterText(textBox_contactReasonLabel, label, " Contact Reason Label Textbox");
        selectFromSearch(textBox_supportArticle, "Appeal Form", "Contact Reason Support Article Textbox");
        clickOnButton(label_NewContactReasons, "Empty Page");
        clickOnButton(button_save, "Save Button");

        By contactReasonLabelOnGrid = By.xpath("//td[contains(text(),'" + label + "')]");
        waitForElementTobeDisplayed(contactReasonLabelOnGrid);
        if (isElementDisplayed(contactReasonLabelOnGrid)) {
            passStep("Contact Reason " + label + " has been displayed on grid");
            passStep("Contact Reason creation is successful ...!!!");
        }

    }
}
