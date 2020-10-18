package Lab_7;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class Lab_7_1 {
    public static void main(String[] args) {
        String key = args[0];
        Map<String, List<String>> mapOfList = new HashMap<String, List<String>>();
        mapOfList.put("Cat", Arrays.asList("Кот"));
        mapOfList.put("Window", Arrays.asList("Окно", "Витрина"));
        mapOfList.put("Table", Arrays.asList("Таблица", "Стол", "Доска", "Расписание"));
        mapOfList.put("House", Arrays.asList("Дом", "Здание", "Строение"));
        mapOfList.put("Green", Arrays.asList("Зелёный", "Зелень", "Трава"));
        System.out.println(mapOfList.get(args[0]));

    }
}
