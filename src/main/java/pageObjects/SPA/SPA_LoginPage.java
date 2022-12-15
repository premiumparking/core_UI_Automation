package pageObjects.SPA;

import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Spa Home page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class SPA_LoginPage extends BaseClass {
    // ****************** WEB ELEMENTS ****************************//
    public By button_SignIn = By.xpath("//span[normalize-space()='Sign in']");
    By textbox_SpaUserName = By.xpath("(//input[@placeholder='Email or Mobile Number'])[1]");
    By textbox_SpaPassword = By.xpath("(//input[@placeholder='Password'])[1]");
    By button_Submit = By.xpath("(//button[@data-testid='submit-btn'])[1]");

    // ****************** ACTIONS ****************************//
    /*
     * Method to navigate to perform spa login
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public SPA_HomePage login(){
        clickOnButton(button_SignIn, "Sign In button");
        enterText(textbox_SpaUserName, BaseClass.spa_username);
        clickOnButton(button_Submit, "Next button after entering username");
        enterText(textbox_SpaPassword, BaseClass.spa_password);
        clickOnButton(button_Submit, "Submit button after entering password ");
        SPA_HomePage spaHomePage = new SPA_HomePage();
        waitForElementTobeDisplayed(spaHomePage.link_premium_parking);
        passStep("Logged in with spa test credentials");
        return new SPA_HomePage();
    }


}
