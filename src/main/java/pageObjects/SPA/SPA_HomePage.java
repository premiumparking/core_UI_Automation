package pageObjects.SPA;


import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Home page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class SPA_HomePage extends BaseClass {

    // ****************** WEB ELEMENTS ****************************//
    By link_premium_parking = By.xpath("//a[@href='https://spa.release.premiumparking.com']");
    By textbox_SearchLocation = By.id("nav_search_text");
    By LocationSearch = By.xpath("(//img[@alt='Search'])[2]");
    By button_Sessions = By.xpath("//button[normalize-space()='Pay to Park Now']");

//    public SPA_SessionsPage navigateToSessionsPage(){
//     //   waitForElementTobeDisplayed(label_sessions);
//        enterText(textbox_SearchLocation, .getName(), "Venue Name Textbox");
//
//
//    }

}
