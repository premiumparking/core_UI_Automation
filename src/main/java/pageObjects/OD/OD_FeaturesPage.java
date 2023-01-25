package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.Feature;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Features page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_FeaturesPage extends BaseClass {
    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_Features = By.xpath("//h2[contains(text(),'Features')]");
    By button_New = By.xpath("//a[normalize-space()='New']");
    By label_NewFeature = By.xpath("//h1[normalize-space()='New Feature']");
    By dd_featureIcon = By.id("existing_icon_title");
    By textBox_featureTitle = By.id("feature_title");
    By textBox_featureUrl = By.id("feature_url");
    By textBox_FeatureDesc = By.xpath("//div[@contenteditable='true']//p");
    By button_create_feature = By.xpath("//div//input[@value='Create Feature']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new feature
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */

    public void create_Feature(Feature feature) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewFeature);
       // selectFromSearch(dd_featureIcon, feature.getFeatureIcon(), "Feature Icon Dropdown");
        enterText(textBox_featureTitle, feature.getFeatureTitle(), "Feature Title Textbox");
        enterText(textBox_featureUrl, feature.getFeatureUrl(), "Feature URL Textbox");
        enterText(textBox_FeatureDesc, feature.getFeatureDesc(), "Feature Description Textbox");
        clickOnButton(button_create_feature, "Button Create Feature");

        By featureTitleOnGrid = By.xpath("//td[contains(.,'" + feature.getFeatureTitle() + "')]");
        waitForElementTobeDisplayed(featureTitleOnGrid);
        if (isElementDisplayed(featureTitleOnGrid)) {
            passStep("Feature " + feature.getFeatureTitle() + " has been displayed on grid");
            passStep("Feature creation is successful ...!!!");
        }

    }
}
