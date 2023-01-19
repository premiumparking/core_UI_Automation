package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.User;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs users page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_UsersPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_Users = By.xpath("//h1[contains(text(),'Users')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewUser = By.xpath("//h1[contains(text(),'New User')]");
    By textBox_firstName = By.id("user_first_name");
    By textBox_lastName = By.id("user_last_name");
    By textBox_email = By.id("user_email");
    By dd_role = By.id("user_role_id");
    By button_create_user = By.xpath("//input[@value='Create User']");
    By button_back_users_page = By.xpath("//a[contains(text(),'Back')]");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new user
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_User(User user) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewUser);
        enterText(textBox_firstName, user.getFirstName(), "First Name  Textbox");
        enterText(textBox_lastName, user.getLastName(), "Last Name Textbox");
        enterText(textBox_email, user.getEmail(), "Email  Textbox");
        selectDropdown(dd_role, user.getRole(), "Role Dropdown");
        clickOnButton(button_create_user, "Create User Button");
        waitForElementTobeClickable(button_back_users_page);
        clickOnButton(button_back_users_page, "Back Button");

        By userEmailOnGrid = By.xpath("//a[contains(text(),'" + user.getEmail() + "')]");
        waitForElementTobeDisplayed(userEmailOnGrid);
        if (isElementDisplayed(userEmailOnGrid)) {
            passStep("User with email " + user.getEmail() + " has been displayed on grid");
            passStep("User creation is successful ...!!!");
        }
    }
}
