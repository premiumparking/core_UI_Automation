package pageObjects.OD;

import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs text pay requests page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_TextPayRequestsPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_TextPayRequests = By.xpath("//h1[contains(text(),'TextPay Requests')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewTextPayRequest = By.xpath("//h1[contains(text(),'New TextPay Request')]");
    By textBox_textPay_request_phone = By.id("textpay_request_phone");
    By dd_locations = By.id("textpay_request_location_id-selectized");
    By button_create_TextPayRequest = By.xpath("//input[@value='Send TextPay']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new text pay request
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_TextPayRequest(String phone, String location) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewTextPayRequest);
        enterText(textBox_textPay_request_phone, phone, "Text Pay Request Phone Number Textbox");
        selectFromSearch(dd_locations, location, "Text Pay Request Location Textbox");
        clickOnButton(button_create_TextPayRequest, "Send TextPay Request Button");

        By textPayRequestPhoneOnGrid = By.xpath("//td[contains(text(),'1" + phone + "')]");
        waitForElementTobeDisplayed(textPayRequestPhoneOnGrid);
        if (isElementDisplayed(textPayRequestPhoneOnGrid)) {
            passStep("Text Pay Request Phone Number " + phone + " has been displayed on grid");
            passStep("Text Pay Request sent is successfully ...!!!");
        }

    }
}
