package project.pages;

import framework.elements.Button;
import framework.elements.Game;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by a.maley on 18.10.2016.
 */
public class ActionsPage extends BasePage {
    private String specialsElementLocatorStr = "//div[@id='tab_select_Discounts']/div[@class='tab_content']";
    private By specialsElementLocator = By.xpath(specialsElementLocatorStr);

   // private By gamesSpecialsLocator = By.xpath("//div[@id='DiscountsRows']//*[@class='discount_pct']");
    private By gamesSpecialsLocator = By.xpath("//div[@id='DiscountsRows']//*[contains(@class,'discount_block tab_item_discount')]");

    public void chooseMaxDiscountGame() {
        Button specialsButton = new Button(specialsElementLocator);
        specialsButton.click();
        Game maxDiscountGame = getMaxDiscountGame();
        maxDiscountGame.click();
    }

    private Game getMaxDiscountGame(){
        List<Game> allGames = getGamesList();
        //return list of Game(locator & webelement)
        ArrayList<String> discountValues = getAllDiscountValues(allGames);

        String maxDiscount = getMaxDiscountString(discountValues);

        Game maxDiscountGame = findGame(allGames, maxDiscount);

        return maxDiscountGame;
    }

    private List<Game> getGamesList(){
        List<WebElement> listElements =  browser.getDriver().findElements(gamesSpecialsLocator);

        List<Game> games = new ArrayList<Game>();
        for (WebElement elem : listElements){
            games.add(new Game(gamesSpecialsLocator, elem));
        }
        return games;

    }

    private ArrayList<String> getAllDiscountValues(List<Game> allGames) {
        ArrayList<String> discountValues = new ArrayList<String>();
        for (Game game : allGames){
            discountValues.add(game.getDiscount());
            // обновляет элемент и находит первый ,
            // а не соответствующий по списку.(создать локатор с contains и текстом внутри данного локатора)
        }
        return discountValues;
    }

    private String getMaxDiscountString(ArrayList<String> discountValues) {
        discountValues.sort(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        return discountValues.get(0);
    }

    private Game findGame(List<Game> allGames, String discount) {
        for (Game game : allGames){
            if (game.isThatDiscount(discount)){
                return game;
            }
        }
        return null;
    }

}
