package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import project.utils.RegexUtil;

import java.util.Comparator;
import java.util.List;

/**
 * Created by a.maley on 24.10.2016.
 */
public class GameTable extends BaseElement {

    private String patternForDiscount = "(-\\d*%)";

    public GameTable(By locator) {
        super(locator);
    }

    private String getText(){
        for (;;){
            try{
                waitElement();
                return element.getText();
            }
            catch (StaleElementReferenceException e){
                info("GameTable object has StaleElementReferenceException");
            }

        }
    }

    public String getMaxDiscountString() {
        List<String> discountStringList = RegexUtil.getMatch(patternForDiscount, getText());
        return getMaxDiscount(discountStringList);
    }

    private String getMaxDiscount(List<String> list) {
        list.sort(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        return list.get(0);
    }
}
