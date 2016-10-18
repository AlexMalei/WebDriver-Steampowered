import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ActionsPage;
import pages.MainPage;
import testUtil.DriverSingleton;
import testUtil.TestUtil;

public class WebDriver_Steam {
    private static WebDriver driver = DriverSingleton.getInstance();

    @BeforeClass
    public static void setUp(){
        driver.get(TestUtil.getWebSite());
    }

    @Test
    public void steamSiteTest_searchingGameAndDownload(){
        MainPage main = new MainPage();
        main.chooseActionsPage();
        ActionsPage actionsPage = new ActionsPage();
        actionsPage.chooseSpecialsCategory();
        actionsPage.getMaxDiscountGame();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
