package project.pages;

import framework.elements.DropDownElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import testUtil.TestUtil;

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
        DropDownElement dropDownElement = new DropDownElement(dropdownGenreGamesLocator);
        dropDownElement.moveMouseOnIt();

        Actions mouse = new Actions(driver);

        mouse.moveToElement(gamesGenreElement).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, TestUtil.getElementTimeout());
        WebElement actionsRef = wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(actionGamesLocator);
            }
        });

        mouse.click(actionsRef).build().perform();




    }
}
