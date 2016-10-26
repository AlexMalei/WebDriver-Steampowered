package framework;

import framework.utils.TestDataProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;


import static framework.BrowserType.valueOf;


public class BrowserFactory extends BaseEntity {
    private static Browser browser;
    private static String resourcesPath = "src" + File.separator + "test" + File.separator + "resources" + File.separator;


    public static synchronized Browser getInstance(){
        if (browser == null){
            BrowserType browserType = valueOf(TestDataProvider.getBrowserName().toUpperCase());
            switch (browserType) {
                case CHROME :

                    System.setProperty("webdriver.chrome.driver",  resourcesPath + "chromedriver.exe");
                    browser = new Browser(new ChromeDriver(getChromeCapabilities()));
                    break;

                case FIREFOX :

                    System.setProperty("webdriver.gecko.driver", resourcesPath + "geckodriver.exe");
                    browser = new Browser(new FirefoxDriver(getFireFoxProfile()));
                    break;
                default:
                    break;
            }
        }
        return browser;
    }
    private static FirefoxProfile getFireFoxProfile(){
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 1);// use default download dir for download file
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
        return profile;
    }

    private static Capabilities getChromeCapabilities(){
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("safebrowsing.enabled", "true");
        chromePrefs.put("chrome.switches", Arrays.asList("--disable-popup-blocking"));

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromeOptionsMap = new HashMap<>();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--test-type");
        cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        return cap;
    }


}
