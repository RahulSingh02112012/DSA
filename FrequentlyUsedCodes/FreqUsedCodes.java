package Tree.FrequentlyUsedCodes;

import java.util.*;
import java.util.stream.Collectors;

public class FreqUsedCodes {
    // Check Zalando files as well
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 1, 2, 3, 3, 4, 4};

        Map<Integer, Long> frequencyMap = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        System.out.println("Element Frequency Map: " + frequencyMap);
    }
}
