package framework.utils;

import java.io.File;

public class FileDownloadUtil {

    private static String downloadPath = System.getProperty("user.home") + File.separator + "Downloads" + File.separator;
    private static String downloadFileName = "SteamSetup.exe";

    public static void waitDownloading(){
        String pathToFile = downloadPath.concat(downloadFileName);
        File file = new File(pathToFile);
        while (!file.exists()){
        }
        while (true){
            long fileLength1 = file.length();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long fileLength2 = file.length();
            if (fileLength1 == fileLength2){
                break;
            }
        }
    }

    public static boolean isPresent(){
        if (new File(downloadPath.concat(downloadFileName)).exists()){
            return true;
        }
        return false;
    }
}
