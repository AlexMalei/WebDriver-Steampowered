package framework.elements;

import framework.BaseEntity;
import framework.Browser;
import framework.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
    protected String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public BaseElement(By locator) {
        this.locator = locator;
    }


    public String getName(){
        return name;
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
                info("Click: " + getClass().getSimpleName() + " " + getName());
                waitElement();
                element.click();
                break;
            }
            catch (StaleElementReferenceException e){
                warn("StaleElementReferenceException in  " + getClass().getName() + e.getSystemInformation());
            }
        }
    }

    public String getText(){
        for (;;){
            try{
                info("GetText: " + getClass().getSimpleName() + " " + getName());
                waitElement();
                return element.getText();
            }
            catch (StaleElementReferenceException e){
                warn("StaleElementReferenceException in  " + getClass().getName() + e.getSystemInformation());
            }

        }
    }

}
