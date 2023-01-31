package pageObjects.OD;

import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs support articles page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_SupportArticlesPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_SupportArticles = By.xpath("//h2[contains(text(),'Support Articles')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewSupportArticle = By.xpath("//h1[contains(text(),'New Support Article')]");
    By textBox_supportArticleTitle = By.id("support_article_title");
    By textBox_supportArticleLink = By.id("support_article_link");
    By button_save = By.xpath("//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new support article
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_supportArticle(String title) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewSupportArticle);
        enterText(textBox_supportArticleTitle, title, " Support Article Title Textbox");
        enterText(textBox_supportArticleLink, "https://www.google.com/", "Support Article Link Textbox");
        clickOnButton(button_save, "Save Button");

        By supportArticleTitleOnGrid = By.xpath("//td[contains(text(),'" + title + "')]");
        waitForElementTobeDisplayed(supportArticleTitleOnGrid);
        if (isElementDisplayed(supportArticleTitleOnGrid)) {
            passStep("Support Article " + title + " has been displayed on grid");
            passStep("Support Article creation is successful ...!!!");
        }

    }
}
