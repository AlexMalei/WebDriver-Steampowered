package framework;

import framework.utils.TestDataProvider;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Hashtable;
import java.util.Map;

import static framework.BrowserType.valueOf;


public class BrowserFactory extends BaseEntity {
    private static Browser browser;
    private static String downloadPath = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "downloadFileDir";


    public static synchronized Browser getInstance(){
        if (browser == null){
            BrowserType browserType = valueOf(TestDataProvider.getBrowserName().toUpperCase());
            switch (browserType) {
                case CHROME :

                    Map<String, Object> preferences = new Hashtable<>();
                    preferences.put("download.default_directory", downloadPath );
                    preferences.put("download.prompt_for_download", "false");
                    /*ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("prefs", preferences);*/
                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    capabilities.setCapability(ChromeOptions.CAPABILITY, preferences);

                    System.setProperty("webdriver.chrome.driver", "src" + File.separator + "test" + File.separator + "resources" + File.separator + "chromedriver.exe");
                    browser = new Browser(new ChromeDriver(capabilities));
                    break;

                case FIREFOX :
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setPreference("browser.download.dir", downloadPath );
                    SteamSetup.exe
                    System.setProperty("webdriver.gecko.driver", "src" + File.separator + "test" + File.separator + "resources" + File.separator + "geckodriver.exe");
                    browser = new Browser(new FirefoxDriver(profile));
                    break;
                default:
                    break;
            }
        }
        return browser;
    }
}
