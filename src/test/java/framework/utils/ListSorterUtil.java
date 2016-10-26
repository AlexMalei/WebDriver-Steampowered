package framework.utils;

import java.util.List;


public class ListSorterUtil {

    public static void sortStringsList(List<String> list){
        list.sort((o1, o2) ->  o2.compareTo(o1));
    }
}
