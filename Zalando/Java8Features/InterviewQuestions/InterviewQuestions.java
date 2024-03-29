package Tree.Zalando.Java8Features.InterviewQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewQuestions {
    public static void main(String[] args) {
        /*
        Q1 - Count the occurance of each char in a string
        We will use groupBy
         */
        String input = "itisabeautifulday";
        // First convert to string[] needed to make each char as Key in a map
        String[] arr = input.split("");

       Map<String, List<String>> map = Arrays.stream(arr)
                                            .collect(Collectors.groupingBy(s->s));
       // this will give <i , [i,i]>
        System.out.println(map);
        Map<String, Long> map1 = Arrays.stream(arr)
                                             .collect(Collectors
                                                    .groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map1);

         /*
        Q2 - Find all duplicate elements from the string
        We will use groupBy
         */
        Map<String, Long> map2 = Arrays.stream(arr)
                .collect(Collectors
                        .groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        // b=1 , s = 1
        List<Map.Entry<String,Long>> map3 = map2.entrySet()
                .stream()
                .filter((ele) -> ele.getValue()<2)
                .collect(Collectors.toList());

        System.out.println(map3);

        // O/p = b,s,d,e
        System.out.println(map2.entrySet()
                .stream()
                .filter((ele) -> ele.getValue()<2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()));

        // First non repeating element
        String firstNonrepeat = map2.entrySet()
                .stream()
                .filter((ele) -> ele.getValue()==1)
                .findFirst().get().getKey();

        System.out.println(firstNonrepeat);

        // But above will print in any order and not preserve ordering so use LinkedHashMap for order preserving

        //WAP to find second highest Number from given array

        int[] arr1 = {1,2,3,4,5};

        System.out.println("second highest Number using skip and limit: "+Arrays.stream(arr1)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .collect(Collectors.toList()).get(0));

        System.out.println("second highest Number using skip and findFirst: "+Arrays.stream(arr1)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get());

        System.out.println("second highest Number using skip and findFirst and exception: "+Arrays.stream(arr1)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow());

        // WAP tp find the longest & shortest string in an array
        String[] arrString = {"spring","springBoot","java","aws"};

        System.out.println("String with longest length: "+Arrays.stream(arrString)
                                   .reduce((word1,word2) -> word1.length() > word2.length() ? word1 : word2)
                                   .get());

        // WAP to print all elements starting with 1 in arr
        int[] intArr = {5,9,11,2,8,21,1};

        System.out.println("elements starting with 1: " + Arrays.stream(intArr)
                .boxed()
                .map(ele -> ele+"")
                .filter(ele -> ele.startsWith("1"))
                .collect(Collectors.toList())
        );



    }
}
