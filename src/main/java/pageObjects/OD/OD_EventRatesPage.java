package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.EventRates;
import org.openqa.selenium.By;


/*
 * Class which contains the web elements and performs Event Rates page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_EventRatesPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_EventRates = By.xpath("//h1[contains(text(),'Event Rates')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewEvent = By.xpath("//h1[contains(text(),'New Event')]");
    By textBox_event_external_name = By.id("event_name");
    By textBox_event_internal_name = By.id("event_internal_name");
    By button_add_rate_group = By.xpath("//a[@data-association='rate_group']");
    By textBox_rate_group_title = By.xpath("//label[contains(normalize-space(),'Title')]/following-sibling::input");
    By button_add_rate = By.xpath("(//a[@data-association-insertion-traversal='prev'])[1]");
    By textBox_rate_location = By.xpath("//input[@type='select-one']");
    By textBox_rate_name = By.xpath("//label[normalize-space()='Name']/following-sibling::input");
    By textBox_rate_minutes = By.xpath("//label[normalize-space()='Minutes']/following-sibling::input");
    By textBox_rate_price = By.xpath("//label[normalize-space()='Price']/following-sibling::input");
    By textBox_rate_pre_tax_price = By.xpath("//label[normalize-space()='Pre tax price']/following-sibling::input");
    By button_create_EventRate = By.xpath("//input[@value='Create Event']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new Event Rate
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_EventRates(EventRates eventRates) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewEvent);
        enterText(textBox_event_external_name, eventRates.getExternalName(), "External Name Textbox");
        enterText(textBox_event_internal_name, eventRates.getInternalName(), "Internal Name Textbox");
        clickOnButton(button_add_rate_group, "Add Rate Group Button");
        enterText(textBox_rate_group_title, eventRates.getRateGroupTitle(), "Rate Group Title Textbox");
        clickOnButton(button_add_rate, "Add Rate Button");
        selectFromSearch(textBox_rate_location, eventRates.getRateLocation(), "Rate Location");
        enterText(textBox_rate_name, eventRates.getRateName(), "Rate Name Textbox");
        enterText(textBox_rate_minutes, eventRates.getRateMinutes(),"Rate Minutes Textbox");
        enterText(textBox_rate_price, eventRates.getRatePrice(), "Rate Price Textbox");
        enterText(textBox_rate_pre_tax_price, eventRates.getRatePreTaxPrice(),"Rate Pre Tax Price Textbox");
        clickOnButton(button_create_EventRate, "Create Event Button");

        By eventRatesNameOnGrid = By.xpath("//td[contains(text(),'" + eventRates.getExternalName() + "')]");
        waitForElementTobeDisplayed(eventRatesNameOnGrid);
        if (isElementDisplayed(eventRatesNameOnGrid)) {
            passStep("Event Rate " + eventRates.getExternalName() + " has been displayed on grid");
            passStep("Event Rate creation is successful ...!!!");
        }

    }
}
