package project.pages;

import framework.elements.Button;
import framework.elements.Selecter;
import org.openqa.selenium.By;
import framework.utils.LocaleDataProvider;

/**
 * Created by a.maley on 20.10.2016.
 */
public class ConfirmAgePage extends BasePage {
    private String verificationString = LocaleDataProvider.getVerificationString();

    private String daySelectLocatorStr = "//form[@id='agecheck_form']//*[@name='ageDay']";
    private String monthSelectLocatorStr = "//form[@id='agecheck_form']//*[@name='ageMonth']";
    private String ageSelectLocatorStr = "//form[@id='agecheck_form']//*[@name='ageYear']";
    private String enterBtnLocatorStr = "//form[@id='agecheck_form']//*[@class='btnv6_blue_hoverfade btn_small']";

    private By daySelectLocator = By.xpath(daySelectLocatorStr);
    private By monthSelectLocator = By.xpath(monthSelectLocatorStr);
    private By yearSelectLocator = By.xpath(ageSelectLocatorStr);
    private By enterBtnLocator = By.xpath(enterBtnLocatorStr);

    private String day = "25";
    private String month = "March";
    private String year = "1997";


    public void checkPageAndDoConfirmation(){
        if (browser.getDriver().getPageSource().contains(verificationString)){
            doConfirmation();
        }
    }

    private void doConfirmation() {
        Selecter daySelecter = new Selecter(daySelectLocator);
        daySelecter.selectValue(day);
        Selecter monthSelecter = new Selecter(monthSelectLocator);
        monthSelecter.selectValue(month);
        Selecter ageSelecter = new Selecter(yearSelectLocator);
        ageSelecter.selectValue(year);
        Button enterButton = new Button(enterBtnLocator);
        enterButton.click();


    }
}
