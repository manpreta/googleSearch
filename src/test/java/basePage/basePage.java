package basePage;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class basePage extends PageObject {


    /***
     *
     * @param driver
     * @param element
     *
     * This method handles multiple type of locaters and StaleElementReferenceException
     */
    public void elementClick(WebDriver driver, Object element) {
        int scount = 1;

        while (true) {
            try {
                if (element instanceof By) {
                    element = driver.findElement((By) element);

                }
                ((WebElement) element).click();
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("inside elementTap StaleElementReferenceException " + scount);
                scount++;
                if (scount == 3) {
                    return;
                }
            }
        }
    }

    public void enterValueWithSendKeys(WebDriver driver, Object object, String value) {
        WebElement element = null;
        int scount = 1;

        while (true) {
            try {
                if (object instanceof By) {
                    element = driver.findElement((By) object);
                }else if (object instanceof WebElement){
                    element = (WebElement) object;
                }
                assert element != null;
                element.clear();
                element.sendKeys(value);
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("inside sendKeys StaleElementReferenceException " + scount);
                scount++;
                if (scount == 3) {
                    return;
                }
            }
        }
    }
}
