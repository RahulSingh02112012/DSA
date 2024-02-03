package Tree.Zalando.Java8Features.MapNReduce;

import java.util.List;

public class ReduceExamples {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8);

        System.out.println(list.stream().reduce(1,(a,b) -> a * b));
        System.out.println(list.stream().reduce(0,(a,b) -> (a + b)/2));
       // System.out.println(list.stream().reduce(Integer::).get());
        System.out.println(list.stream().reduce(Integer::sum).get());
        System.out.println(list.stream().reduce(Integer::max).get());

        System.out.println((list.stream().reduce(0,(a,b) -> a > b ? a : b)));

        List<String> stringList = List.of("coreJava","spring","lamda","hibernate");

        System.out.println(stringList.stream().reduce((word1,word2) -> word1.length() > word2.length() ? word1 : word2).get());

        // Get employees grade = A find avg
        // employeeList.stream().filter(emp -> emp.getGrade().equalsIgnoreCase("A"))
        //                  .map(emp -> emp.getSalary()).mapToDouble(i->i).average().get();
    }
}
