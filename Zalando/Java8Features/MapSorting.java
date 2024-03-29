package Tree.Zalando.Java8Features;

import java.time.Instant;
import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapSorting {
    public static void main(String[] args) {
        // Sort Map based on key or Value
        Map<String ,Integer> map = Map.of("eight", 8, "four",4, "six",6,"seven",7);



        //Method 1:
        List<Map.Entry<String ,Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, Comparator.comparing(Map.Entry::getKey));
        //Collections.sort(entries, (o1, o2) ->  o1.getKey().compareTo(o2.getKey()));
       // entries.stream().forEach(System.out::println);

        //Method 2:
      /*  map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
                .forEach(System.out::println);

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
*/        Map<String ,Integer> map1 = Map.of("eight", 8, "four",4, "six",6,"seven",7);
        map1.entrySet().stream()
                .sorted(Map.Entry.<String ,Integer>comparingByValue().reversed()).limit(2)
                .map(Map.Entry::getKey).collect(Collectors.toList()).stream().forEach(System.out::println);

        Map<String, Integer> topEntriesMap = map1.entrySet().stream()
                                                    .sorted(Map.Entry.<String ,Integer>comparingByValue().reversed())
                                                    .limit(2).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                                                (oldValue, newValue) ->newValue, LinkedHashMap::new));

        Map<String, Integer> topEntriesMap1 = map1.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(2)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(), // Key mapper function
                        entry -> entry.getValue(), // Value mapper function
                        (existingValue, newValue) -> existingValue, // Merge function
                        LinkedHashMap::new // Supplier for the new map
                ));

        topEntriesMap.entrySet().stream().forEach((entry) -> System.out.println(entry.getKey()));

        /*
        If custom object:
        employeeMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey(Comparartor.comparing(Employee::getDept))).forEach(System.out::println);
         */

        System.out.println(IntStream.of(new int[]{1,2,3,4}).boxed().max(Comparator.naturalOrder()).get());
        System.out.println(Arrays.stream(new int[]{1,2,3,4}).max().getAsInt());



    }
}
