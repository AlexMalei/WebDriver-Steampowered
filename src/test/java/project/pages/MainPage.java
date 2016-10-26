package project.pages;

import framework.elements.Button;
import framework.elements.Menu;
import framework.utils.RegexUtil;
import framework.utils.TestDataProvider;
import org.openqa.selenium.By;
import framework.utils.LocaleDataProvider;


public class MainPage extends BasePage {
    private String gameType = LocaleDataProvider.getActionsString();

    private String menuGenreGamesLocatorStr = "//div[contains(@id, 'genre_tab')]";
    private By menuGenreGamesLocator = By.xpath(menuGenreGamesLocatorStr);

    private String pulldownLanguageLocatorStr = "//*[contains(@id, 'language_pulldown')]";
    private By pulldownLanguageLocator = By.xpath(pulldownLanguageLocatorStr);

    private String btnLanguageLocatorStr = "//*[contains(@id, 'language_dropdown')]//*[contains(text(),'%s') and contains(@class,'popup_menu_item')]";


    private static String languageIdentifierRus = "язык";
    private static String languageIdentifierEng = "language";


    private static final String LANGUAGE_RUS = "Русский";
    private static final String LANGUAGE_ENG = "English";
    private static final String UNKNOWN_LANGUAGE = "Unknown language";

    private String patternPageLangHTML = "<html [\\s\\S]*?lang=\"([\\s\\S]*?)\">";
    private String patternPageTitleHTML = "<title>([\\s\\S]*?)<\\/title>";

    private Menu gamesMenu;

    public void chooseActionsPage() {
        info("Choosing genre action");
        gamesMenu = new Menu(menuGenreGamesLocator, "\"Game genre menu\"");
        gamesMenu.selectItem(gameType);
    }

    public void checkLanguage() {
        info("Check page language");
        String languageFormFile = LocaleDataProvider.getLanguage();
        String pageLanguage = getPageLanguage();

        if (!( languageFormFile.equals(pageLanguage) || (languageFormFile.equals(pageLanguage)))) {
            Button pulldownLanguage = new Button(pulldownLanguageLocator, "\"Pulldown language\"");
            pulldownLanguage.click();
            Button btnLanguage = new Button(By.xpath(String.format(btnLanguageLocatorStr, languageFormFile)), "\"Choosing Language\"");
            btnLanguage.click();
        }
    }

    private String getPageLanguage(){
        Button btnLanguage = new Button(pulldownLanguageLocator, "\"Pulldown language\"");
        String textBtnLanguage = btnLanguage.getText();
        if (textBtnLanguage.contains(languageIdentifierRus)){
            return LANGUAGE_RUS;
        }
        if (textBtnLanguage.contains(languageIdentifierEng)){
            return LANGUAGE_ENG;
        }
        return UNKNOWN_LANGUAGE;
    }

    public String getTitle() {
        info("Get page title");
        waitChangingLanguage();
        String htmlPage = browser.getDriver().getPageSource();
        return RegexUtil.getMatch(patternPageTitleHTML, htmlPage);
    }

    private void waitChangingLanguage(){
        String htmlPage;
        String pageLanguage;
        do {
            htmlPage = browser.getDriver().getPageSource();
            pageLanguage = RegexUtil.getMatch(patternPageLangHTML, htmlPage);
        } while (!pageLanguage.equals(TestDataProvider.getLanguageFromFile().toLowerCase()));
    }

}
