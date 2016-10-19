package framework;

import org.openqa.selenium.WebDriver;

/**
 * Created by a.maley on 19.10.2016.
 */
public class Browser extends BaseEntity {
    private WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public void exit(){
        driver.quit();
    }

    public void navigate(String url){
        driver.get(url);
    }

    public WebDriver getDriver(){
        return driver;
    }


}
