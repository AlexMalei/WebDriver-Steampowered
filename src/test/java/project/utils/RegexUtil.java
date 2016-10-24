package project.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by a.maley on 20.10.2016.
 */
public class RegexUtil {
    public static List<String> getMatch(String patternStr, String text){
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);
        List<String> listMatches = new ArrayList<String>();

        while (matcher.find()){
            listMatches.add(matcher.group(1));
        }

        return listMatches;
    }
}
