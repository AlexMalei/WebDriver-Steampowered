package project.pages;

import framework.elements.Button;
import framework.elements.Game;
import org.openqa.selenium.By;
import project.utils.GamesUtil;

/**
 * Created by a.maley on 18.10.2016.
 */
public class ActionsPage extends BasePage {
    private String specialsElement = "//div[@id='tab_select_Discounts']/div[@class='tab_content']";
    private By specialsElementLocator = By.xpath(specialsElement);
    private By gamesSpecialsLocator = By.xpath("//div[@id='DiscountsRows']//*[@class='discount_pct']");

    public void chooseMaxDiscountGame() {
        Button specialsButton = new Button(specialsElementLocator);
        specialsButton.click();
        Game maxDiscountGame = GamesUtil.getMaxDiscountGame(browser.getDriver().findElements(gamesSpecialsLocator));
    }

   /* public void chooseSpecialsCategory(){
        WebElement specials = browser.findElement(specialsElementLocator);
        specials.click();
    }

    List<WebElement> discountElements;
    public void getMaxDiscountGame(){
        new WebDriverWait(driver, TestUtil.getElementTimeout()).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                discountElements = driver.findElements();
                return discountElements.size() != 0;
            }
        });

        for (WebElement el : discountElements){
            System.out.println(el.getText());
        }

    }*/


}
