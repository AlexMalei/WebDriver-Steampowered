package project.pages;

import framework.elements.Menu;
import org.openqa.selenium.By;

/**
 * Created by a.maley on 17.10.2016.
 */
public class MainPage extends BasePage {
    private String gameType = "Action";

    private String dropdownGenreGames = "//div[@id='genre_tab']";
    private By dropdownGenreGamesLocator = By.xpath(dropdownGenreGames);



    public void chooseActionsPage() {
        Menu gamesMenu = new Menu(dropdownGenreGamesLocator);
        gamesMenu.selectItem(gameType);
    }
}
