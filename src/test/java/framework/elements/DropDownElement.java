package framework.elements;

import org.openqa.selenium.By;

/**
 * Created by a.maley on 19.10.2016.
 */
public class DropDownElement extends BaseElement {
    public DropDownElement(By locator) {
        super(locator);
    }


    public void moveMouseOnIt() {
        waitElement();

    }
}
