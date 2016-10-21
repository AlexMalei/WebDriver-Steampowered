package project.pages;

import framework.Browser;
import framework.BrowserFactory;


public abstract class BasePage {
    protected final Browser browser;

    public BasePage(){
        this.browser = BrowserFactory.getInstance();
    }

}
