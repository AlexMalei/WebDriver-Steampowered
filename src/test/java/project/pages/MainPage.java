package project.pages;

import framework.elements.Button;
import framework.elements.Menu;
import org.openqa.selenium.By;
import testUtil.LocaleDataProvider;

/**
 * Created by a.maley on 17.10.2016.
 */
public class MainPage extends BasePage {
    private String gameType = "Action";

    private String menuGenreGamesLocatorStr = "//div[contains(@id, 'genre_tab')]";
    private By menuGenreGamesLocator = By.xpath(menuGenreGamesLocatorStr);

    private String menuLanguageLocatorStr = "//*[contains(@id, 'language_pulldown')]";
    private By menuLanguageLocator = By.xpath(menuLanguageLocatorStr);

    private String btnLanguageLocatorStr = "//*[contains(@id, 'global_action_menu')]";
    private By btnLanguageLocator = By.xpath(btnLanguageLocatorStr);

    public void chooseActionsPage() {
        Menu gamesMenu = new Menu(menuGenreGamesLocator);
        gamesMenu.selectItem(gameType);
    }

    public void checkLanguage() {
        // check current language of page & language from config file
        Button btnLanguage = new Button(btnLanguageLocator)
        //boolean isCorrectLanguage =
        Menu menuLanguage = new Menu(menuLanguageLocator);
        menuLanguage.selectItem(LocaleDataProvider.getLanguage());

    }
}
