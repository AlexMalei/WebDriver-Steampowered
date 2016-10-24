package framework.elements;

import org.openqa.selenium.By;

/**
 * Created by a.maley on 19.10.2016.
 */
public class Button extends BaseElement {


    public Button(By locator){
        super(locator);
    }


    public void click() {
        for (;;){
            try{
                waitElement();
                element.click();
            }
            catch (Exception e){
                info("Error :", e);
            }
        }
    }
}
