package pages;

import org.openqa.selenium.WebDriver;
import testUtil.DriverSingleton;


public class BasePage {
    protected final WebDriver driver;

    public BasePage(){
        this.driver = DriverSingleton.getInstance();
    }

}
