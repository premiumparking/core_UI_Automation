package pageObjects.TextPay;

import components.BaseClass;
import dataModel.SPA.Vehicle;
import org.openqa.selenium.By;

public class TextPay_SessionsPage extends BaseClass {

    // ****************** WEB ELEMENTS ****************************//
    By textbox_SearchLocation = By.id("address-search");
    By button_Search = By.xpath("//button[@data-testid='destination-search-button']");
    By button_Sessions = By.xpath("//button[normalize-space()='Pay to Park Now']");
    By button_ViewRate = By.xpath("//button[normalize-space()='View rate']");
    By button_ParkHere = By.xpath("//button[normalize-space()='Park here']");
    By label_Total = By.xpath("//strong[normalize-space()='Total']");
    By textbox_LicensePlateNumber = By.id("license_plate-for-1");
    By dropdown_state = By.id("state-for-1");
    By select_AnotherCard = By.xpath("//button[normalize-space()='another card']");
    By textbox_CardNumber = By.id("cardNumber");
    By textbox_ExpDate = By.id("cardExpiry");
    By textbox_CVC = By.id("cardCVC");
    By textbox_ZipCode = By.id("zip");
    By button_Pay = By.xpath("button[type='submit']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to purchase a new session
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void purchase_Session(String cardNumber, String expiryDate, String cvc, Vehicle vehicle){
        //enterText(textbox_SearchLocation, vehicle.getLocationNumber(), "Search Location Textbox");
        selectFromSearch(textbox_SearchLocation, vehicle.getLocationNumber(), "Search Location Textbox");
        clickOnButton(button_Search, "Search Icon");
        waitForElementTobeDisplayed(button_Sessions);
        clickOnButton(button_Sessions, "Pay to Park Now");
        clickOnButton(button_ViewRate, "View Rate");
        clickOnButton(button_ParkHere, "Park Here");
        waitForElementTobeDisplayed(label_Total);
        enterText(textbox_LicensePlateNumber, vehicle.getLicensePlateNumber(), "License Plate Number Textbox");
        selectFromSearch(dropdown_state, vehicle.getState(), "License Plate State dropdown");
        clickOnButton(select_AnotherCard, "Pay with another card");
        enterText(textbox_CardNumber, cardNumber, "Card Number Textbox");
        enterText(textbox_ExpDate, expiryDate, "Expiry Date Textbox");
        enterText(textbox_CVC, cvc, "CC_CVC code Textbox");
        enterText(textbox_ZipCode, vehicle.getZip(), "Zip Code Textbox");
        clickOnButton(button_Pay, "Pay Button");
    }

}
