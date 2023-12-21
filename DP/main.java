package Tree.DP;

import java.util.List;
import java.util.stream.Collectors;


public class main {
    public static void main(String[] args) {
        List<String> strings = List.of("1,2,3");

        System.out.println(String.join(",", strings));

        System.out.println(getElement(strings));

    }

    private static String getElement(List<String> shipments) {
        return shipments.stream().collect(Collectors.joining(","));
    }

}
