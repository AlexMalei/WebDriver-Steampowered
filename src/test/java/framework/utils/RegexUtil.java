package framework.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexUtil {
    private static List<String> getMatchList(String patternStr, String text){
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);
        List<String> listMatches = new ArrayList<>();

        while (matcher.find()){
            listMatches.add(matcher.group(1));
        }
        return listMatches;
    }
    public static String getMatch(String patternStr, String textElement){
        List<String> discounts = RegexUtil.getMatchList(patternStr,textElement);
        return discounts.get(0);
    }
    public static String getSortedMatch(String patternStr, String textElement){
        List<String> discounts = RegexUtil.getMatchList(patternStr,textElement);
        ListSorterUtil.sortStringsList(discounts);
        return discounts.get(0);
    }
}
