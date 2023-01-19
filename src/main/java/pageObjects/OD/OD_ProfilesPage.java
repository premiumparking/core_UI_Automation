package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.Profile;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs profiles page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_ProfilesPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_Profiles = By.xpath("//h1[contains(text(),'Profiles')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewProfile = By.xpath("//h1[contains(text(),'New Profile')]");
    By textBox_firstName = By.id("profile_first_name");
    By textBox_lastName = By.id("profile_last_name");
    By textBox_email = By.id("profile_email");
    By textBox_phone = By.id("profile_phone");
    By button_create_profile = By.xpath("//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new profile
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_Profile(Profile profile) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewProfile);
        enterText(textBox_email, profile.getEmail(), "Email  Textbox");
        enterText(textBox_firstName, profile.getFirstName(), "First Name  Textbox");
        enterText(textBox_lastName, profile.getLastName(), "Last Name Textbox");
        enterText(textBox_phone, profile.getPhone(), "Email  Textbox");
        clickOnButton(button_create_profile, "Create User Button");

        By profileEmailAfterCreation = By.xpath("//td[contains(text(),'" + profile.getEmail() + "')]");
        waitForElementTobeDisplayed(profileEmailAfterCreation);
        if (isElementDisplayed(profileEmailAfterCreation)) {
            passStep("Profile with email " + profile.getEmail() + " has been displayed ");
            passStep("Profile creation is successful ...!!!");
        }
    }

}
