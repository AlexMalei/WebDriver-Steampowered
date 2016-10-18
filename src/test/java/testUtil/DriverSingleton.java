package testUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static  WebDriver driver;

    public static synchronized WebDriver getInstance() {

        if (driver == null) {
            String driverSrting = TestUtil.getBrowserName().toLowerCase();


            if (driverSrting.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
            if (driverSrting.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
            }

        }
        return driver;
    }
}
