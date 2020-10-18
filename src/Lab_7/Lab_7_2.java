package Lab_7;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Lab_7_2 {
    public static void main(String[] args) {

        String argument = args[0];
        //String argument ="Table";
        //String argument = "Доска";

        Map<String, List<String>> mapOfList = new HashMap<String, List<String>>();
        mapOfList.put("Cat", Arrays.asList("Кот"));
        mapOfList.put("Window", Arrays.asList("Окно", "Витрина"));
        mapOfList.put("Table", Arrays.asList("Таблица", "Стол", "Доска", "Расписание"));
        mapOfList.put("House", Arrays.asList("Дом", "Здание", "Строение"));
        mapOfList.put("Green", Arrays.asList("Зелёный", "Зелень", "Трава"));

        Set set = mapOfList.entrySet();
        if (mapOfList.containsKey(argument)) {
            System.out.println(mapOfList.get(args[0]));
            //System.out.println(mapOfList.get(argument));
        } else {
            for (Map.Entry<String, List<String>> entry : mapOfList.entrySet()) {
                if (entry.getValue().contains(argument)) {
                    System.out.print(entry.getKey());
                }
            }
        }
    }
}
