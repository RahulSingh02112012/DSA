package Tree.Zalando.Java8Features;

import java.util.HashMap;
import java.util.*;

public class MapSorting {
    public static void main(String[] args) {
        // Sort Map based on key or Value
        Map<String ,Integer> map = Map.of("eight", 8, "four",4, "six",6,"seven",7);



        //Method 1:
        List<Map.Entry<String ,Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, Comparator.comparing(Map.Entry::getKey));
        //Collections.sort(entries, (o1, o2) ->  o1.getKey().compareTo(o2.getKey()));
        entries.stream().forEach(System.out::println);

        //Method 2:
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
                .forEach(System.out::println);
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        /*
        If custom object:
        employeeMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey(Comparartor.comparing(Employee::getDept))).forEach(System.out::println);
         */



    }
}
