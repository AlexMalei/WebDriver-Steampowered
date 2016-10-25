package framework.elements;

import framework.BaseEntity;
import framework.Browser;
import framework.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.utils.TestDataProvider;

import java.util.List;


public class BaseElement extends BaseEntity {

    protected Browser browser = BrowserFactory.getInstance();
    protected WebElement element;
    protected By locator;


    public BaseElement(By locator) {
        this.locator = locator;
    }



    public void waitElement() {
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), TestDataProvider.getElementTimeout());

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                List<WebElement> elements = browser.getDriver().findElements(locator);
                for (WebElement elem : elements) {
                    if (elem.isDisplayed() && elem.isEnabled()) {
                        element = elem;
                        return true;
                    }
                }
                return false;
            }
        });


    }

    public void click() {
        for (;;){
            try{
                waitElement();
                element.click();
                break;
            }
            catch (Exception e){
                warn("Exception: " + e.getMessage());
            }
        }
    }

    public String getText(){
        for (;;){
            try{
                waitElement();
                return element.getText();
            }
            catch (Exception e){
                warn("Exception:" + e.getMessage());
            }

        }
    }

}
