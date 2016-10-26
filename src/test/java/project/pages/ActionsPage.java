package project.pages;

import framework.elements.BaseTable;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;
import project.utils.GameInfo;
import framework.utils.RegexUtil;


public class ActionsPage extends BasePage {
    private String specialsElementLocatorStr = "//div[@id='tab_select_Discounts']/div[@class='tab_content']";
    private By specialsElementLocator = By.xpath(specialsElementLocatorStr);

    private String gameTableLocatorStr = "//*[@id='DiscountsRows']";
    private By gameTableLocator = By.xpath(gameTableLocatorStr);

    private String gameLocatorStr = "//*[@id='DiscountsRows']//*[contains(text(), '%s')]//..//..";

    private String patternPrice = "\\$([\\d]*.[\\d]*)?";
    private String patternDiscount = "(-\\d*%)";




    public GameInfo chooseMaxDiscountGame() {
        info("Choose max discount game");
        Button specialsButton = new Button(specialsElementLocator, "\"Specials button\"");
        specialsButton.click();
        BaseTable baseTable = new BaseTable(gameTableLocator, "\"Game table\"");
        String maxDiscount = RegexUtil.getSortedMatch(patternDiscount, baseTable.getText());
        Label game = new Label(By.xpath(String.format(gameLocatorStr, maxDiscount)), "\"Max discount game\"");
        GameInfo gameInfo = new GameInfo(maxDiscount, RegexUtil.getMatch(patternPrice, game.getText()));
        game.click();

        return gameInfo;
    }


}
