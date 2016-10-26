package framework.elements;

import org.openqa.selenium.By;


public class BaseTable extends BaseElement {


    public BaseTable(By locator) {
        super(locator);
    }

    public BaseTable(By locator, String name) {
        super(locator, name);
    }
}
