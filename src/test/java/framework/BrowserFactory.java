package framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import testUtil.TestUtil;

import static framework.BrowserType.*;


public class BrowserFactory extends BaseEntity{
    private static Browser browser;

    public static synchronized Browser getInstance(){
        if (browser == null){
            BrowserType browserType = valueOf(TestUtil.getBrowserName().toLowerCase());
            switch (browserType) {
                case CHROME :
                    browser = new Browser(new ChromeDriver());
                    break;
                case FIREFOX :
                    browser = new Browser(new FirefoxDriver());
                    break;
                default:
                    break;
            }
        }
        return browser;
    }
}
