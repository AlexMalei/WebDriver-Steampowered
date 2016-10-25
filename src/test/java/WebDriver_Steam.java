import framework.BaseEntity;
import framework.Browser;
import framework.BrowserFactory;
import framework.utils.LocaleDataProvider;
import framework.utils.TestDataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.pages.*;
import project.utils.GameInfo;

import static org.testng.Assert.assertTrue;

public class WebDriver_Steam extends BaseEntity {
    private static Browser browser;

    @BeforeClass
    public static void setUp(){
        TestDataProvider.setUpData();
        LocaleDataProvider.setUpData();
        browser = BrowserFactory.getInstance();
        browser.navigate(TestDataProvider.getWebSite());
        MainPage mainPage = new MainPage();
        mainPage.checkLanguage();
    }

    @Test
    public void steamSiteTest_searchingGameAndDownload(){
        MainPage main = new MainPage();
        main.chooseActionsPage();
        ActionsPage actionsPage = new ActionsPage();
        GameInfo gameInfoExpected = actionsPage.chooseMaxDiscountGame();

        ConfirmAgePage confirmAgePage = new ConfirmAgePage();
        confirmAgePage.checkPageAndDoConfirmation();
        GamePage gamePage = new GamePage();

        GameInfo gameInfoActual = gamePage.getGameDiscount();
        assertTrue(gameInfoActual.equals(gameInfoExpected));

        gamePage.downloadSteam();
        InstallationPage installPage = new InstallationPage();
        installPage.install();
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
