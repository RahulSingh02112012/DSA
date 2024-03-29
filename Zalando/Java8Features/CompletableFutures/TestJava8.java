package Tree.Zalando.Java8Features.CompletableFutures;

import java.util.List;
import java.util.Set;

public class TestJava8 {
    public static void main(String[] args) {
        List<String> list = List.of("Apple","Orange","Anar","Guava","Mango");
        Set<String> set = Set.of("Apple","Orange","Anar","Guava","Mango");

        set.stream().map((t) -> t.toLowerCase()).filter((t)->t.startsWith("a")).forEach((t)->System.out.println(t));
        set.stream().filter((t) -> t.toLowerCase().startsWith("a")).forEach(System.out::println);
    }
}
