package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import testUtil.TestUtil;

import java.util.List;

/**
 * Created by a.maley on 18.10.2016.
 */
public class ActionsPage extends BasePage {
    private String specialsElement = "//div[@id='tab_select_Discounts']/div[@class='tab_content']";
    private By specialsElementLocator = By.xpath(specialsElement);

    public void chooseSpecialsCategory(){
        WebElement specials = browser.findElement(specialsElementLocator);
        specials.click();
    }

    List<WebElement> discountElements;
    public void getMaxDiscountGame(){
        new WebDriverWait(driver, TestUtil.getElementTimeout()).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                discountElements = driver.findElements(By.xpath("//div[@id='DiscountsRows']//*[@class='discount_pct']"));
                return discountElements.size() != 0;
            }
        });

        for (WebElement el : discountElements){
            System.out.println(el.getText());
        }

    }


}
