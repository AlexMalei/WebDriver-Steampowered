package testUtil;

import org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;

public class JSONReader {
    private JSONObject jsonObject;

    public JSONReader(String fileConfigPath) {
        this.jsonObject = readJSONFile(fileConfigPath);
    }

    private static JSONObject readJSONFile(String fileConfigPath){
        File file = new File(fileConfigPath);
        FileInputStream fis;
        String filePropContent;
        byte[] data = new byte[(int) file.length()];
        try {
            fis = new FileInputStream(file);
            fis.read(data);
            fis.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        filePropContent = new String(data);
        return new JSONObject(filePropContent);
    }

    public String getWebSite(){
        return (String) jsonObject.get("URL");
    }

    public String getBrowserName(){
        return (String) jsonObject.get("Browser");
    }

    ////////////////!!!!!!!!!
    public Integer getPagetTimeout(){
        return Integer.parseInt((String) jsonObject.get("pageTimeout"));
    }

    ////////////////!!!!!!!!!
    public Integer getElementTimeout() {
        return Integer.parseInt((String) jsonObject.get("elementTimeout"));
    }

    public String getLocale(){
        return (String) jsonObject.get("locale");
    }
}
