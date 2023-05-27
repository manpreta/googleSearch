package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import serenityDefinition.serenityDefinition;

public class stepDefinition {

        @Steps
        serenityDefinition serenityDefinition;

        @Given("^user opens google.com$")
        public void userOpensGoogleCom() {
                serenityDefinition.userOpensGoogleCom();
        }

        @And("^navigates to Search and enters text '(.*)'$")
        public void searchText(String value) {
                serenityDefinition.searchText(value);
        }

        @And("^clicks Google Search button$")
        public void clickSearch() {
                serenityDefinition.clickSearch();
        }

        @And("^verifies that first link is '(.*)'$")
        public void validateFirstResult(String value) {
                serenityDefinition.validateFirstResult(value);
        }
}
