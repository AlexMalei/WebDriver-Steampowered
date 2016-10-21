package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.regex.Pattern;

/**
 * Created by a.maley on 19.10.2016.
 */
public class Game extends BaseElement {

    private String patternStrForFindXPath = "By\\.xpath: (\\/\\/[\\s\\S]*)";
    private String patternForDiscount = "(-\\d*%)";
    Pattern patternForFindXPath = Pattern.compile(patternStrForFindXPath);
    private String discountGameLocatorPartStr = "//*[@class='tab_item_name' and contains(text(), %s)]/../..//*[contains(@class, 'discount_pct')]";
    /* {locator of game element}//*[@class='tab_item_name' and contains(text(), %s)]/../..//*[contains(@class, 'discount_pct')]
    */
    private By discountGameLocator;


    public Game(By locator) {
        super(locator);
    }

    public Game(By locator, WebElement element) {
        super(locator);
        this.element = element;
    }



    public void click() {
        for (;;){
            try{
                waitElement();
                element.click();
                break;
            }
            catch (StaleElementReferenceException e){
                info("click() game method has exception");
            }
        }
        /*try{
            waitElement();
            element.click();
        }
        catch (StaleElementReferenceException e){
            info("Recursive click() game method");
            click();
        }*/
        //waitElement();
        //element.click();

    }

    public String getDiscount(){//old locator of all element includes gametext, pricetext, currentprice & discount
        //String oldLocatorStr = RegexUtil.getMatch(patternForFindXPath, locator.toString());//get old locatorStr from locator
       // info(oldLocatorStr);
        //locator
        info(getElementText());
        //String x = String.format(oldLocatorStr.concat(String.format(discountGameLocatorPartStr, getElementText())));
        //discountGameLocator = By.xpath(x);
        //info(x);
        //GameDiscount discountElement = new GameDiscount()
        String text = getElementText();
        info(text);
        return text;
    }

    private String getElementText() {
        for (;;){
            try {
                return this.element.getText();
            }
            catch (StaleElementReferenceException e){
                waitElement();
                info("GetElementText() game method has exception");
            }
        }
        /*try {
            return this.element.getText();
        }
        catch (StaleElementReferenceException e){
            waitElement();
            info("Recursive getElementText() game method");
            return getElementText();
        }*/
    }


    public boolean isThatDiscount(String maxDiscount){
        return getElementText().contains(maxDiscount);
    }
}
