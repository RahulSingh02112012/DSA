package Tree.Zalando.Java8Features.InterviewQuestions;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class FinfNthHighestSalary {
    public static void main(String[] args) {
        // WAP to get nth highest salary

                Map<String, Integer> map = Map.of(      "a",10,
                                                "b",20,
                                                "c",30,
                                                "d",40,
                                                "e",50
                );

                System.out.println("Second Hightest Salary without duplicates: "+
                        map.entrySet().stream()
                                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                                .collect(Collectors.toList())
                                .get(1)
                        );

                // Above code will not work when we have duplicates salary for employees

        Map<String, Integer> map2 = Map.of(      "a",10,
                "f",10,
                "b",20,
                "c",30,
                "g",30,
                "d",15,
                "e",50
        );
        System.out.println("Second Highest Salary with duplicates: "+
                map2.entrySet().stream()
                        .collect(Collectors.groupingBy(Map.Entry::getValue,
                                Collectors.mapping(Map.Entry::getKey,Collectors.toList())))
                        .entrySet()
                        .stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                        .collect(Collectors.toList())
                        .get(1)
        );

        // Take List of List and then map to a key and sort by value desc


    }
}
