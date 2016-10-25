package project.pages;

import framework.elements.Button;
import framework.elements.Menu;
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

    public void chooseActionsPage() {
        Menu gamesMenu = new Menu(menuGenreGamesLocator);
        gamesMenu.selectItem(gameType);
    }

    public void checkLanguage() {

        String languageFormFile = LocaleDataProvider.getLanguage();
        String pageLanguage = getPageLanguage();

        if (!( languageFormFile.equals(pageLanguage) || (languageFormFile.equals(pageLanguage)))) {
            Button pulldownLanguage = new Button(pulldownLanguageLocator);
            pulldownLanguage.click();
            Button btnLanguage = new Button(By.xpath(String.format(btnLanguageLocatorStr, languageFormFile)));
            btnLanguage.click();
        }
    }

    private String getPageLanguage(){
        Button btnLanguage = new Button(pulldownLanguageLocator);
        String textBtnLanguage = btnLanguage.getText();
        if (textBtnLanguage.contains(languageIdentifierRus)){
            return LANGUAGE_RUS;
        }
        if (textBtnLanguage.contains(languageIdentifierEng)){
            return LANGUAGE_ENG;
        }
        return UNKNOWN_LANGUAGE;
    }
}
