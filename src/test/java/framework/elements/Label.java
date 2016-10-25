package framework.elements;

import org.openqa.selenium.By;

/**
 * Created by a.maley on 24.10.2016.
 */
public class Label extends BaseElement {
    public Label(By locator) {
        super(locator);
    }

    public String getText(){
        for (;;){
            try{
                waitElement();
                return element.getText();
            }
            catch (Exception e){
                info("Error :", e);
            }
        }
    }
}
