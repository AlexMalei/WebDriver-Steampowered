import framework.BaseEntity;
import framework.Browser;
import framework.BrowserFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.pages.ActionsPage;
import project.pages.ConfirmAgePage;
import project.pages.MainPage;
import testUtil.TestDataProvider;

public class WebDriver_Steam extends BaseEntity {
    private static Browser browser = BrowserFactory.getInstance();

    @BeforeClass
    public static void setUp(){
        browser.navigate(TestDataProvider.getWebSite());
    }

    @Test
    public void steamSiteTest_searchingGameAndDownload(){
        MainPage main = new MainPage();
        main.chooseActionsPage();
        ActionsPage actionsPage = new ActionsPage();
        actionsPage.chooseMaxDiscountGame();
        ConfirmAgePage confirmAgePage = new ConfirmAgePage();
        confirmAgePage.checkPageAndDoConfirmation();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown(){
        browser.exit();
    }
}
