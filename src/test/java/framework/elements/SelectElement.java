package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class SelectElement extends BaseElement {

    private org.openqa.selenium.support.ui.Select select;

    public SelectElement(By locator) {
        super(locator);
    }

    public SelectElement(By locator, String name) {
        super(locator, name);
    }

    public void selectValue(String value){
        info("Select value" + getClass().getSimpleName() + " " + getName());
        waitElement();
        select = new org.openqa.selenium.support.ui.Select(element);
        select.selectByValue(value);
    }

}
