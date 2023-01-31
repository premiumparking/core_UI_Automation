package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.Banner;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Banners page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_BannersPage extends BaseClass {
    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_Banners = By.xpath("//h2[contains(text(),'Banner Messages')]");
    By button_New = By.xpath("//a[normalize-space()='New']");
    By label_NewBannerMessage = By.xpath("//h1[normalize-space()='New Banner Message']");
    By dd_banner_market = By.id("banner_message_market_id");
    By textBox_banner_starts = By.id("banner_message_starts_at");
    By textBox_banner_ends = By.id("banner_message_ends_at");
    By textBox_banner_photo = By.id("banner_message_photo");
    By textBox_banner_title = By.id("banner_message_title");
    By textBox_banner_body = By.xpath("//div[@contenteditable='true']//p");
    By button_save_banner = By.xpath("//div//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new Banner
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */

    public void create_Banner(Banner banner) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewBannerMessage);
        selectDropdown(dd_banner_market, banner.getBannerMarket(), "Banner Market Dropdown");
        enterText(textBox_banner_starts, banner.getBannerStartsAt(), "Banner Starts At Textbox");
        enterText(textBox_banner_ends, banner.getBannerEndsAt(), "Banner Ends At Textbox");
        enterText(textBox_banner_photo, System.getProperty("user.dir") + banner.getBannerPhoto(), "Banner Photo Textbox");
        enterText(textBox_banner_title, banner.getBannerTitle(), "Banner Title Textbox");
        enterText(textBox_banner_body, banner.getBannerBody(), "Banner Body Textbox");
        clickOnButton(button_save_banner, "Button Create Banner");

        By bannerTitleOnGrid = By.xpath("//td[contains(.,'" + banner.getBannerTitle() + "')]");
        waitForElementTobeDisplayed(bannerTitleOnGrid);
        if (isElementDisplayed(bannerTitleOnGrid)) {
            passStep("Banner Title " + banner.getBannerTitle() + " has been displayed on grid");
            passStep("Banner creation is successful ...!!!");
        }

    }
}
