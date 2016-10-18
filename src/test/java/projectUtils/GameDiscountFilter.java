package projectUtils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by a.maley on 18.10.2016.
 */
public class GameDiscountFilter {
    private List<WebElement> elementList;

    public GameDiscountFilter(List<WebElement> elementList) {
        this.elementList = elementList;
    }

    public WebElement getGameMaxDiscount(){
        WebElement maxDiscountElement = elementList.get(0);
        Pattern discountPattern = Pattern.compile("-([\\S]*)%");
        Matcher matcher;
        try {
            matcher = discountPattern.matcher(maxDiscountElement.getText());
        }
        catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
        matcher.find();
        int maxDiscount = Integer.parseInt(matcher.group());
        System.out.println(maxDiscount);

        return null;
    }
}
