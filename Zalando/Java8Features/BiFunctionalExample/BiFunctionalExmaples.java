package Tree.Zalando.Java8Features.BiFunctionalExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

// Use Bifunction when 2 arguments there
public class BiFunctionalExmaples implements BiFunction<List<Integer>, List<Integer>, List<Integer>> {

    @Override
    public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
        return List.of(list1,list2).stream()
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        BiFunction bi = new BiFunctionalExmaples();
        System.out.println(bi.apply(List.of(1,2,3,4,5), List.of(2,3,5,7,8)));

        Map<String ,Integer> map = new HashMap<>();
    }
}
