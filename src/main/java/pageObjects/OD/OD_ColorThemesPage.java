package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.ColorTheme;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Color Themes page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_ColorThemesPage extends BaseClass {

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_ColorThemes = By.xpath("//h2[contains(text(),'Color Themes')]");
    By button_New = By.xpath("//a[normalize-space()='New']");
    By label_NewColorTheme = By.xpath("//h1[normalize-space()='New']");
    By textBox_theme_name = By.id("color_theme_name");
    By textBox_content_color = By.id("color_theme_content_color");
    By textBox_text_color = By.id("color_theme_text_color");
    By textBox_button_BG_color = By.id("color_theme_button_color");
    By textBox_button_text_color = By.id("color_theme_button_text_color");
    By button_save_color_theme = By.xpath("//div//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new color theme
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */

    public void create_ColorTheme(ColorTheme colorTheme) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewColorTheme);
        enterText(textBox_theme_name, colorTheme.getThemeName(), "Banner Starts At Textbox");
        enterText(textBox_content_color, colorTheme.getContentBoxBGColor(), "Banner Ends At Textbox");
        enterText(textBox_text_color, colorTheme.getContentBoxTextColor(), "Banner Photo Textbox");
        enterText(textBox_button_BG_color, colorTheme.getButtonsBGColor(), "Banner Title Textbox");
        enterText(textBox_button_text_color, colorTheme.getButtonColor(), "Banner Body Textbox");
        clickOnButton(button_save_color_theme, "Button Create Color Theme");

        By colorThemeNameOnGrid = By.xpath("//td[contains(.,'" + colorTheme.getThemeName() + "')]");
        waitForElementTobeDisplayed(colorThemeNameOnGrid);
        if (isElementDisplayed(colorThemeNameOnGrid)) {
            passStep("Color Theme Name " + colorTheme.getThemeName() + " has been displayed on grid");
            passStep("Color Theme creation is successful ...!!!");
        }

    }
}
