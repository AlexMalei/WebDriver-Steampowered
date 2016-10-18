package testUtil;

public class TestUtil {
    private final static String fileConfigPath = "src\\test\\resources\\config.properties";
    private static JSONReader jsonReader;

    private static String browserName;
    private static String webSite;
    private static int pageTimeout;
    private static int elementTimeout;

    private boolean isRusLocale;


    static {
        jsonReader = new JSONReader(fileConfigPath);
        webSite = jsonReader.getWebSite();
        pageTimeout = jsonReader.getPagetTimeout();
        browserName = jsonReader.getBrowserName();
        elementTimeout = jsonReader.getElementTimeout();
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

    public boolean isRusLocale() {
        return isRusLocale;
    }

    public void setRusLocale(boolean rusLocale) {
        isRusLocale = rusLocale;
    }
}
