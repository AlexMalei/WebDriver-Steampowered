package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


public class Menu extends BaseElement {

    private String typeGameLocatorStr = "//div[contains(@class, 'popup_menu')]//a[contains(text(),\'%s\')]";

    public Menu(By locator) {
        super(locator);
    }

    public Menu(By locator, String name) {
        super(locator, name);
    }

    private void moveMouseOnIt() {
        info("Moving mouse on games menu");
        waitElement();
        Actions mouse = new Actions(browser.getDriver());
        mouse.moveToElement(element).build().perform();
    }


    public void selectItem(String itemString) {
        moveMouseOnIt();
        Button btnActions = new Button(By.xpath(String.format(typeGameLocatorStr, itemString)), "\"Action\"");
        btnActions.click();
    }
}
