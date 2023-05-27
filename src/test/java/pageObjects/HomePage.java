package pageObjects;

import basePage.basePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends basePage {

    HomePage(){
        PageFactory.initElements(getDriver(),this);
    }

    @CacheLookup
    @FindBy(css = "#APjFqb")
    WebElement searchInput;

    @CacheLookup
    @FindBy(xpath = "//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")
    WebElement searchButton;

    @CacheLookup
    @FindBy(css = "div#result-stats")
    WebElement resultsStats;

    @FindBy(xpath = "//div[@class='yuRUbf']//a[@href]/h3")
    List<WebElement> searchList;


    WebDriverWait driverWait;

    public void explicitWait(String condition, WebElement webElement) {

        if (driverWait == null) //singleton pattern
            driverWait = new WebDriverWait(getDriver(), 15);

        System.out.println(driverWait.hashCode());

        if (condition.equalsIgnoreCase("elementVisibility")) {
            driverWait.until(ExpectedConditions.visibilityOf(webElement));

        } else if (condition.equalsIgnoreCase("completePageLoad")) {
            long initial = System.currentTimeMillis();
            driverWait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            System.out.println( (float) (System.currentTimeMillis() - initial) /1000);
        }

    }

    public void userOpensGoogleCom() {
        getDriver().get("https://google.com");
        explicitWait("completePageLoad",null);
        Assert.assertTrue("title mismatch", getDriver().getTitle().toLowerCase().contains("google"));
    }


    public void searchText(String value) {
        enterValueWithSendKeys(getDriver(), searchInput, value );
        searchInput.sendKeys(Keys.TAB);
    }

    public void clickSearch() {
        elementClick(getDriver(), searchButton);
    }

    public void validateFirstResult(String value) {
        explicitWait("elementVisibility",resultsStats);

        Assert.assertTrue("Expected "+value.trim()+" but actual "+searchList.get(0).getText().trim(), searchList.get(0).getText().trim().equalsIgnoreCase(value));
    }
}
