package framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import testUtil.TestUtil;

import static framework.BrowserType.*;


public class BrowserFactory extends BaseEntity{
    private static Browser browser;

    public static synchronized Browser getInstance(){
        if (browser == null){
            BrowserType browserType = valueOf(TestUtil.getBrowserName().toUpperCase());
            switch (browserType) {
                case CHROME :
                    System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
                    browser = new Browser(new ChromeDriver());
                    break;
                case FIREFOX :
                    System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
                    browser = new Browser(new FirefoxDriver());
                    break;
                default:
                    break;
            }
        }
        return browser;
    }
}
