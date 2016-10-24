package framework.elements;

import org.openqa.selenium.By;

/**
 * Created by a.maley on 24.10.2016.
 */
public class GameDiscount extends BaseElement{
    public GameDiscount(By locator) {
        super(locator);
    }

    public void click() {
        waitElement();
        element.click();
    }

    public void getText(){
        waitElement();
        element.click();
    }
}
