package project.pages;

import framework.elements.Button;
import framework.elements.GameDiscount;
import framework.elements.GameTable;
import org.openqa.selenium.By;

/**
 * Created by a.maley on 18.10.2016.
 */
public class ActionsPage extends BasePage {
    private String specialsElementLocatorStr = "//div[@id='tab_select_Discounts']/div[@class='tab_content']";
    private By specialsElementLocator = By.xpath(specialsElementLocatorStr);

    private String gameTableLocatorStr = "//*[@id='DiscountsRows']";
    private By gameTableLocator = By.xpath(gameTableLocatorStr);

    private String gameLocatorStr = "//*[@id='DiscountsRows']//*[contains(@class, 'tab_item')]//*[contains(text(), '%s')]";


    public void chooseMaxDiscountGame() {
        Button specialsButton = new Button(specialsElementLocator);
        specialsButton.click();

        GameTable gameTable = new GameTable(gameTableLocator);
        String discountString = gameTable.getMaxDiscountString();

        GameDiscount maxDiscountElement = new GameDiscount(By.xpath(String.format(gameLocatorStr, discountString)));
        maxDiscountElement.click();
        //Game maxDiscountGame = getMaxDiscountGame();  //   !!
        //maxDiscountGame.click();
    }

   /* private Game getMaxDiscountGame(){


       /* List<Game> allGames = getGamesList();
        //return list of Game(locator & webelement)
        ArrayList<String> discountValues = getAllDiscountValues(allGames);
        String maxDiscount = getMaxDiscountString(discountValues);
        Game maxDiscountGame = findGame(allGames, maxDiscount);
        return maxDiscountGame;
    }*/

   /* private List<Game> getGamesList(){
        List<WebElement> listElements =  browser.getDriver().findElements(gamesSpecialsLocator);

        List<Game> games = new ArrayList<Game>();
        for (WebElement elem : listElements){
            games.add(new Game(gamesSpecialsLocator, elem));
        }
        return games;*/

    //}

   /* private ArrayList<String> getAllDiscountValues(List<Game> allGames) {
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
*/
}
