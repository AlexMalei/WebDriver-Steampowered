package testUtil;

import framework.BaseEntity;

import java.io.File;

public class TestDataProvider extends BaseEntity {
    private final static String fileConfigPath = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "config.json";
    private static JSONReader jsonReader;

    private static String browserName;
    private static String webSite;
    private static int pageTimeout;
    private static int elementTimeout;


    private static String languageFromFile;

    public static void setUpData(){
        jsonReader = new JSONReader(fileConfigPath);
        webSite = jsonReader.getWebSite();
        pageTimeout = jsonReader.getPagetTimeout();
        browserName = jsonReader.getBrowserName();
        elementTimeout = jsonReader.getElementTimeout();
        languageFromFile = jsonReader.getLocale();
    }

    public static String getWebSite() {
        return webSite;
    }

    public static int getElementTimeout(){
        return elementTimeout;
    }

    public static int getPageTimeout() {
        return pageTimeout;
    }

    public static String getBrowserName(){
        return browserName;
    }

    public static String getLanguageFromFile(){
        return languageFromFile;
    }


}
