package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by a.maley on 19.10.2016.
 */
public class Menu extends BaseElement {

    private String typeGameLocatorStr = "//div[contains(@class, 'popup_menu')]//a[contains(text(),\'%s\')]";

    public Menu(By locator) {
        super(locator);
    }


    private void moveMouseOnIt() {
        waitElement();
        Actions mouse = new Actions(browser.getDriver());
        mouse.moveToElement(element).build().perform();
    }


    public void selectItem(String itemString) {
        moveMouseOnIt();
        Button btnActions = new Button(By.xpath(String.format(typeGameLocatorStr, itemString)));
        btnActions.click();
    }
}
