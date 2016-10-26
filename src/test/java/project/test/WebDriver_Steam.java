package project.test;

import framework.BaseEntity;
import framework.Browser;
import framework.BrowserFactory;
import framework.utils.FileDownloadUtil;
import framework.utils.LocaleDataProvider;
import framework.utils.TestDataProvider;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.pages.*;
import project.utils.GameInfo;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebDriver_Steam extends BaseEntity {
    private static Browser browser;

    @BeforeClass
    public static void setUp(){
        info("\n                BEFORE TEST\n");
        TestDataProvider.setUpData();
        LocaleDataProvider.setUpData();
        browser = BrowserFactory.getInstance();
        browser.navigate(TestDataProvider.getWebSite());
        MainPage mainPage = new MainPage();
        mainPage.checkLanguage();
    }

    @Test
    public void steamSiteTest_searchingGameAndDownload(){
        info("\n\n                  STEP 1: CHOOSE ACTIONS\n");
        MainPage main = new MainPage();
        assertEquals(main.getTitle(), LocaleDataProvider.getExpectedTitleMainPage());
        main.chooseActionsPage();
        info("\n\n                  STEP 2: CHOOSE MAX DISCOUNT GAME\n");
        ActionsPage actionsPage = new ActionsPage();
        GameInfo gameInfoExpected = actionsPage.chooseMaxDiscountGame();
        info("\n\n                  STEP 3: CONFIRM AGE\n");
        ConfirmAgePage confirmAgePage = new ConfirmAgePage();
        confirmAgePage.checkPageAndDoConfirmation();
        info("\n\n                  STEP 4: GET GAME INFO\n");
        GamePage gamePage = new GamePage();

        GameInfo gameInfoActual = gamePage.getGameDiscount();
        assertTrue(gameInfoActual.equals(gameInfoExpected));
        info("\n\n                  STEP 5: DOWNLOAD STEAM\n");
        gamePage.downloadSteam();
        InstallationPage installPage = new InstallationPage();
        installPage.install();
        FileDownloadUtil.waitDownloading();
        assertTrue(FileDownloadUtil.isPresent());

    }

    @AfterClass
    public void tearDown(){
        browser.exit();
    }
}
