package project.pages;

import framework.elements.Button;
import framework.elements.SelectElement;
import org.openqa.selenium.By;
import framework.utils.LocaleDataProvider;


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
        info("Check confirmation");
        if (browser.getDriver().getPageSource().contains(verificationString)){
            doConfirmation();
        }
    }

    private void doConfirmation() {
        info("Do confirmation");
        SelectElement daySelectElement = new SelectElement(daySelectLocator, "\"Day select\"");
        daySelectElement.selectValue(day);
        SelectElement monthSelectElement = new SelectElement(monthSelectLocator, "\"Month select\"");
        monthSelectElement.selectValue(month);
        SelectElement ageSelectElement = new SelectElement(yearSelectLocator, "\"Year select\"");
        ageSelectElement.selectValue(year);
        Button enterButton = new Button(enterBtnLocator, "\"Confirmation age\"");
        enterButton.click();


    }
}
