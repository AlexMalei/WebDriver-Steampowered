package framework.elements;

import com.sun.org.apache.xpath.internal.operations.Bool;
import framework.BaseEntity;
import framework.Browser;
import framework.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import testUtil.TestUtil;

import java.util.List;

/**
 * Created by a.maley on 17.10.2016.
 */
public class BaseElement extends BaseEntity {

    protected Browser browser = BrowserFactory.getInstance();
    protected WebElement element;
    protected By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }



    private boolean isPresent() {
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), TestUtil.getElementTimeout());
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                try {
                    List<WebElement> elements = browser.getDriver().findElements(locator);
                    for (WebElement element : elements){
                        if (element.isDisplayed()){
                            return true;
                        }
                    }
                    return false;
                }
                catch (Exception e){
                    //here will be some operations with logger
                }
            }
        });

    }

    protected void waitElement(){
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), TestUtil.getElementTimeout());
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                List<WebElement> elements = browser.getDriver().findElements(locator);
                for (WebElement elem : elements){
                    if (elem.isEnabled() && elem.isDisplayed()){
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
