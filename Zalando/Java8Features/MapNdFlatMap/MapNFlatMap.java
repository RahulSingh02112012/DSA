package Tree.Zalando.Java8Features.MapNdFlatMap;

import java.util.List;
import java.util.stream.Collectors;

public class MapNFlatMap {
    public static void main(String[] args) {
        List<Customer> customersList = EkartDataBase.getAll();

        // Map is used when we have one -> One mapping
         customersList.stream()
                 .map(customer -> customer.getEmail()).collect(Collectors.toList())
                .stream().forEach(System.out::println);

         // flatmap is used for one to many mapping
         customersList.stream().flatMap(customer -> customer.getPhoneNumbers().stream()).collect(Collectors.toList())
                 .stream().forEach(System.out::println);



    }
}
