package project.utils;

import java.util.List;

/**
 * Created by a.maley on 25.10.2016.
 */
public class StringSorterUtil {

    public static void sortStringsList(List<String> list){
        list.sort((o1, o2) ->  o2.compareTo(o1));
    }
}
