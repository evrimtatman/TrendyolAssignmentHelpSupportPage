package org.example;

import com.codeborne.selenide.SelenideElement;
import org.example.constants.HelpSupportConstants;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SupportHelpPage extends BasePage {


    void healthSupportPageContains(String term) {
        $(By.cssSelector(".featured-question-button")).shouldHave(text(term));
    }

    Boolean noResultFound() {
        return $(By.cssSelector(".mw-search-nonefound")).isDisplayed();
    }


    public void clickItemList(String term) {
        SelenideElement elem = findByCss(HelpSupportConstants.SupportHelpPage.ITEM_LIST);
        $(byText(term)).click();
    }

    public String getMenuText(String term) {
        return $(term).getText();
    }

    public void verifyTexts(String text1, String text2) {
        Assert.assertEquals(text1, text2);

    }

    public void verifySiparisListesiExpandMenu() {
        clickItemList(HelpSupportConstants.SupportHelpPage.ORDER_TRACK);
        String siparisTakibi = getMenuText(HelpSupportConstants.SupportHelpPage.ACCORDION_MENU);

        clickItemList(HelpSupportConstants.SupportHelpPage.BASKET_MERGE);
        String siparisBirlestirme = getMenuText(HelpSupportConstants.SupportHelpPage.ACCORDION_MENU);
        verifyTexts(siparisTakibi, siparisBirlestirme);

        clickItemList(HelpSupportConstants.SupportHelpPage.REFUND_ORDER);
        String iadeIslemi = getMenuText(HelpSupportConstants.SupportHelpPage.ACCORDION_MENU);
        verifyTexts(siparisTakibi, iadeIslemi);
    }

}
