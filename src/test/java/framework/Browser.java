package framework;

import org.openqa.selenium.WebDriver;


public class Browser extends BaseEntity {
    private WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public void exit(){
        driver.quit();
    }

    public void navigate(String url){
        info("Navigate to website");
        driver.get(url);
    }

    public WebDriver getDriver(){
        return driver;
    }


}
