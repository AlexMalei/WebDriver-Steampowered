package project.pages;


import framework.elements.Button;
import org.openqa.selenium.By;

public class InstallationPage extends BasePage {

    private String btnInstallLocatorStr = "//*[contains(@id, 'install_steam_link')]";
    private By btnInstallLocator = By.xpath(btnInstallLocatorStr);

    public void install() {
        Button btnInstall = new Button(btnInstallLocator);
        btnInstall.click();
    }
}
