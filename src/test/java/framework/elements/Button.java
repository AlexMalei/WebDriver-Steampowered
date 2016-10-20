package framework.elements;

import org.openqa.selenium.By;

/**
 * Created by a.maley on 19.10.2016.
 */
public class Button extends BaseElement {
    private String typesGameLocatorStr = "//div[@class='popup_body popup_menu']//a[contains(text(),\'%s\')]";

    public Button(By locator){
        super(locator);
    }

    public Button(String name){
        super(name);
        locator = By.xpath(String.format(typesGameLocatorStr, name));
    }

    public void click() {
        waitElement();
        element.click();
    }
}
