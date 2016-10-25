package project.pages;

import framework.BaseEntity;
import framework.Browser;
import framework.BrowserFactory;


public abstract class BasePage extends BaseEntity {
    protected final Browser browser;

    public BasePage(){
        this.browser = BrowserFactory.getInstance();
    }

}
