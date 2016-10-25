package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class Selecter extends BaseElement {

    private Select select;

    public Selecter(By locator) {
        super(locator);
    }


    public void selectValue(String value){
        waitElement();
        select = new Select(element);
        select.selectByValue(value);
    }

}
