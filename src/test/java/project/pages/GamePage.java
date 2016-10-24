package project.pages;

import framework.elements.GameDiscount;
import framework.elements.Label;
import org.openqa.selenium.By;

/**
 * Created by a.maley on 24.10.2016.
 */
public class GamePage extends BasePage {

    private String labelNameLocatorStr = "//*[contains(@class,'page_content')]//*[@class='apphub_AppName']";
    private By labelNameLocator = By.xpath(labelNameLocatorStr);
    private String discountLocatorStr = "//*[contains(@class, 'purchase_game')]//*[contains(text(),'%s')]" +
            "/following-sibling::*//*[contains(@class,'discount_pct')]";

    public String getGameName(){
        Label labelName = new Label(labelNameLocator);
        return labelName.getText();
    }

    public String getGameDiscount(){
        String gameName = getGameName();
        GameDiscount gameDiscount = new GameDiscount(By.xpath(String.format(discountLocatorStr, gameName)));

        return gameDiscount.getText();
    }
}
