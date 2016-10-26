package project.pages;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;
import project.utils.GameInfo;
import framework.utils.RegexUtil;


public class GamePage extends BasePage {

    private String discountLocatorStr = "//*[contains(@id, 'game_area_purchase')]//*[contains(@class, 'purchase_action')]//*[contains(@class, 'game_purchase_discount')]";
    private By discountLocator = By.xpath(discountLocatorStr);

    private String btnSteamDownloadLocatorStr = "//*[contains(@id, 'global_action_menu')]/*[contains(@class, 'installsteam_btn')]";
    private By btnSteamDownloadLocator = By.xpath(btnSteamDownloadLocatorStr);

    private String patternPrice = "\\$([\\d]*.[\\d]*)?";
    private String patternDiscount = "(-\\d*%)";

    public GameInfo getGameDiscount(){
        info("Get game discount");
        Label gameCurrent = new Label(discountLocator, "\"Game from Game table\"");
        String labelText = gameCurrent.getText();
        return new GameInfo(RegexUtil.getMatch(patternDiscount, labelText), RegexUtil.getMatch(patternPrice, labelText));

    }

    public void downloadSteam() {
        info("Download steam from GamePage");
        Button button = new Button(btnSteamDownloadLocator, "\"Download steam\"");
        button.click();
    }
}
