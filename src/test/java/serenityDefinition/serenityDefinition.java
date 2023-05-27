package serenityDefinition;

import net.thucydides.core.annotations.Step;
import pageObjects.HomePage;

public class serenityDefinition {

    HomePage homePage;

    @Step
    public void userOpensGoogleCom() {
        homePage.userOpensGoogleCom();
    }

    @Step
    public void searchText(String value) {
        homePage.searchText(value);
    }

    @Step
    public void clickSearch() {
        homePage.clickSearch();
    }

    @Step
    public void validateFirstResult(String value) {
        homePage.validateFirstResult(value);
    }
}
