import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TruckItemMapping {
    public static List<Integer> findTruckIndices(List<Integer> trucks, List<Integer> items) {
        int n = trucks.size();
        int m = items.size();

        // Create a TreeSet to store truck capacities along with their indices
        TreeSet<int[]> truckSet = new TreeSet<>((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        for (int i = 0; i < n; i++) {
            truckSet.add(new int[]{trucks.get(i), i});
        }

        // Result list to store the indices
        List<Integer> result = new ArrayList<>();

        // Iterate through each item
        for (int itemWeight : items) {
            int[] truckEntry = truckSet.ceiling(new int[]{itemWeight + 1, 0});

            if (truckEntry == null) {
                // No truck can carry the item
                result.add(-1);
            } else {
                // Add the index of the chosen truck to the result list
                result.add(truckEntry[1]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //List<Integer> trucks = List.of(4, 5, 7, 2);
        //List<Integer> items = List.of(1, 2, 5);

       // List<Integer> trucks = List.of(5,3,8,1);
       // List<Integer> items = List.of(6,10);

        List<Integer> trucks = List.of(1,3,5,2,3,2);
        List<Integer> items = List.of(1, 2, 3);

        List<Integer> result = findTruckIndices(trucks, items);

        System.out.println("Result is: " + result);
    }
}
