package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.Venue;
import org.openqa.selenium.By;

public class VenuesPage extends BaseClass {

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_Venues = By.xpath("//h2[contains(text(),'Venues')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewVenue = By.xpath("//h1[contains(text(),'New Venue')]");
    By textbox_venue_name = By.id("venue_name");
    By textbox_venue_address = By.id("venue_address");
    By textbox_venue_city = By.id("venue_city");
    By textbox_venue_zip = By.id("venue_zip");
    By textbox_venue_latitude = By.id("venue_latitude");
    By textbox_venue_longitude = By.id("venue_longitude");
    By textbox_venue_phone = By.id("venue_phone");
    By textbox_venue_email = By.id("venue_email");
    By textbox_venue_url = By.id("venue_url");
    By textbox_venue_description = By.xpath("//p[contains(normalize-space(),'\u200B')]");
    By checkbox_venue_cruise = By.id("venue_cruise");
    By textbox_venue_hours = By.id("venue_hours");
    By textbox_venue_color_theme = By.id("venue_color_theme_id");
    By textbox_venue_meta_tag_title = By.id("venue_meta_tag_attributes_title");
    By textbox_venue_meta_tag_description = By.id("venue_meta_tag_attributes_description");
    By button_save_venue = By.xpath("//div//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new Market
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */

    public void create_Venue(Venue venue) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewVenue);
//        if (venue.getVisible().equalsIgnoreCase("True"))
//            select_Checkbox(checkbox_market_visible, "Checkbox_Visible");
        enterText(textbox_venue_name, venue.getName(), "Venue Name Textbox");
        enterText(textbox_venue_address, venue.getAddress(), "Venue Address Textbox");
        enterText(textbox_venue_city, venue.getCity(), "Venue City Textbox");
        enterText(textbox_venue_zip, venue.getZip(), "Venue Zip Textbox");
        enterText(textbox_venue_latitude, venue.getLatitude(), "Venue Lattitude Textbox");
        enterText(textbox_venue_longitude, venue.getLongitude(), "Venue Longitude Textbox");
        enterText(textbox_venue_phone, venue.getPhone(), "Venue Phone Textbox");
        enterText(textbox_venue_email, venue.getEmail(), "Venue Email Textbox");
        enterText(textbox_venue_url, venue.getUrl(), "Venue Url Textbox");
        enterText(textbox_venue_description, venue.getDescription(), "Venue Description Textbox");
        enterText(textbox_venue_hours, venue.getHours(), "Venue Hours Textbox");
        enterText(textbox_venue_meta_tag_title, venue.getMetaTagTitle(), "Venue Meta Tag Title Textbox");
        enterText(textbox_venue_meta_tag_description, venue.getMetaTagDescription(), "Venue Meta Tag Description Textbox");
        clickOnButton(button_save_venue, "Button Create Venue");

        By venueNameOnVenuesGrid = By.xpath("//td//a[contains(.,'" + venue.getName() + "')]");
        waitForElementTobeDisplayed(venueNameOnVenuesGrid);
        if (isElementDisplayed(venueNameOnVenuesGrid)) {
            passStep("Venue " + venue.getName() + " has been displayed on grid");
            passStep("Venue creation is successful ...!!!");
        }

    }

}
