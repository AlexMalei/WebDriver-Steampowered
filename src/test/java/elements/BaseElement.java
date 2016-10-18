package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testUtil.DriverSingleton;

/**
 * Created by a.maley on 17.10.2016.
 */
public class BaseElement {

    protected WebDriver driver = DriverSingleton.getInstance();
    protected WebElement element;
    protected By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }


    private void waitElement(){
        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                List<WebElement> elements = driver.findElements(locator);
                //here would be a logger
                for (WebElement webElement : elements){
                    //here will be code for searching current web element
            }
        })

        }*/
    }
}
