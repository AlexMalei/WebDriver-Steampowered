package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

/**
 * Created by a.maley on 19.10.2016.
 */
public class Game extends BaseElement {

    public Game(By locator) {
        super(locator);
    }

    public Game(By locator, WebElement element) {
        super(locator);
        this.element = element;
    }

    public void click() {
        try{
            waitElement();
            element.click();
        }
        catch (StaleElementReferenceException e){
            info("Recursive click() game method");
            click();
        }
        //waitElement();
        //element.click();

    }

    public String getDiscount(){
        String text = getElementText();
        info(text);
        return text;
    }

    private String getElementText() {
        try {
            return this.element.getText();
        }
        catch (StaleElementReferenceException e){
            waitElement();
            info("Recursive getElementText() game method");
            return getElementText();
        }
    }


    public boolean isThatDiscount(String maxDiscount){
        return getElementText().contains(maxDiscount);
    }
}
