package project.pages;

import framework.elements.Menu;
import framework.elements.Button;
import org.openqa.selenium.By;

/**
 * Created by a.maley on 17.10.2016.
 */
public class MainPage extends BasePage {
    private String gameType = "\'Action\'";
    private String dropdownGenreGames = "//div[@id='genre_tab']";
    private String actionGames = String.format("//div[@class='popup_body popup_menu']//a[contains(text(),%s)]", gameType);


   // private By locator = By.xpath("//*[@id='genre_flyout']/div/a[5]");

    private By dropdownGenreGamesLocator = By.xpath(dropdownGenreGames);
    private By actionGamesLocator = By.xpath(actionGames);


    public void chooseActionsPage() {
        Menu menuGames = new Menu(dropdownGenreGamesLocator);
        menuGames.moveMouseOnIt();
        Button btnActionGames = new Button(actionGamesLocator);
        btnActionGames.click();

    }
}
