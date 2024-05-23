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
        String s = "tree";
        // Get char freq of a string
        Map<Character, Long> sMap = s.chars()
                .mapToObj(c-> (char) c)
                .collect(Collectors.groupingBy(
                        c ->c,
                        Collectors.counting()
                ));

        System.out.println("Element Frequency Map: " + frequencyMap);
        System.out.println("Element Frequency Map: " + sMap);
        String st = "lfFtcode";
        int i = st.charAt(1)- '0';
        int j = st.charAt(2)- '0';

        System.out.println(i - j);
        Long count = List.of(1,2,3,4).stream().filter(k -> k%2 == 0).count();

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana", "cherry"),
                Arrays.asList("date", "elderberry", "fig"),
                Arrays.asList("grape", "honeydew", "kiwi")
        );

        List<String> listFlatted = listOfLists.stream()
                .flatMap(List::stream)
                .filter(str -> str.length() %2 == 0)
                .collect(Collectors.toList());

        System.out.println(listFlatted);
    }

    public void countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
    }

    // List<List<>> to int[][]
    /*
    result.stream()
                .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

     result.toArray(new int[result.size()][]);
     */

    // FlatMap:



}
