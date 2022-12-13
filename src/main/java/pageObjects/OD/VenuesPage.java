package pageObjects.OD;

import components.BaseClass;
import dataModel.Profile;
import org.openqa.selenium.By;

public class VenuesPage extends BaseClass {

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
    By textbox_venue_description = By.id("venue_description");
    By checkbox_venue_cruise = By.id("venue_cruise");
    By textbox_venue_hours = By.id("venue_hours");
    By textbox_venue_color_theme = By.id("venue_color_theme_id");
    By textbox_venue_meta_tag_title = By.id("venue_meta_tag_attributes_title");
    By textbox_venue_meta_tag_description = By.id("venue_meta_tag_attributes_description");
    By button_Save = By.xpath("//div//input[@value='Save']");

//    public void createProfile(Profile profile) {
//        passStep("Creating profile : " + profile.getEmail());
//
//        waitForElementTobeDisplayed(button_New);
//        clickOnButton(button_New, "New Button");
//        waitForElementTobeDisplayed(label_NewProfile);
//        enterText(textbox_profile_email, profile.getEmail(), "Email field");
//        enterText(textbox_profile_first_name, profile.getFirstName(), "First Name field");
//        enterText(textbox_profile_last_name, profile.getLastName(), "Last Name field");
//        enterText(textbox_profile_address, profile.getAddress(), "Address field");
//        selectFromSearch(textbox_profile_concierge_locations, profile.getLocation(), "Permitted concierge locations");
//        performClick(textbox_profile_address);
//        waitForPageLoad(1);
//        clickOnButton(button_Save, "Save");
//        passStep("<b>Profile : "+profile.getEmail()+" created successfully !!! </b>");
//        navigate_To_Profiles_Page();
//    }
}
