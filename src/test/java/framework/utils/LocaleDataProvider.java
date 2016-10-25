package framework.utils;

import framework.BaseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class LocaleDataProvider extends BaseEntity {

    private static String localeENPath = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "localeEN.properties";
    private static String localeRUPath = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "localeRU.properties";
    private static String language;

    private static Properties properties = new Properties();

    public static void setUpData(){
        try {
            switch (TestDataProvider.getLanguageFromFile().toLowerCase()){
                case ("en"): {
                    language = "English";
                    properties.load(new FileInputStream(new File(localeENPath)));
                    break;
                }
                case ("ru") : {
                    language = "Русский";
                    properties.load(new FileInputStream(new File(localeRUPath)));
                    break;
                }
                default:
                    warn("Locale isn't RUSSIAN or ENGLISH");
            }
        }
        catch (Exception e){
            warn("Error: ", e);
        }
    }

    public static String getActionsString(){
        return (String) properties.get("mainPage.actions");
    }

    public static String getVerificationString(){
        return (String) properties.get("confirmAgePage.verificationString");
    }

    public static String getLanguage(){
        return language;
    }

}
