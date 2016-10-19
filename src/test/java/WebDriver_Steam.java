import framework.Browser;
import framework.BrowserFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.pages.ActionsPage;
import project.pages.MainPage;
import testUtil.TestUtil;

public class WebDriver_Steam {
    private static Browser browser = BrowserFactory.getInstance();

    @BeforeClass
    public static void setUp(){
        browser.navigate(TestUtil.getWebSite());
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
        browser.exit();
    }
}