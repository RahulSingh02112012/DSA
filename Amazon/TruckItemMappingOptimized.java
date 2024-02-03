import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class TruckItemMappingOptimized {
    public static List<Integer> findTruckIndices(List<Integer> trucks, List<Integer> items) {
        int n = trucks.size();
        int m = items.size();

        // Create a list of truck objects with capacities and original indices
        List<Truck> truckList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            truckList.add(new Truck(trucks.get(i), i));
        }

        // Sort the truck list based on capacities
        Collections.sort(truckList);

        // Result list to store the indices
        List<Integer> result = new ArrayList<>();

        // Iterate through each item
        for (int itemWeight : items) {
            int truckIndex = binarySearch(truckList, itemWeight);

            if (truckIndex == -1) {
                // No truck can carry the item
                result.add(-1);
            } else {
                // Add the original index of the chosen truck to the result list
                result.add(truckList.get(truckIndex).originalIndex);
            }
        }

        return result;
    }

    // Binary search to find the smallest truck with capacity greater than or equal to itemWeight
    private static int binarySearch(List<Truck> truckList, int itemWeight) {
        int left = 0;
        int right = truckList.size() - 1;
        int resultIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (truckList.get(mid).capacity >= itemWeight) {
                resultIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return resultIndex;
    }



    // Truck class to store both capacity and original index
    static class Truck implements Comparable<Truck> {
        int capacity;
        int originalIndex;

        public Truck(int capacity, int originalIndex) {
            this.capacity = capacity;
            this.originalIndex = originalIndex;
        }

        @Override
        public int compareTo(Truck other) {
            return Integer.compare(this.capacity, other.capacity);
        }
    }

    public static void main(String[] args) {
        //List<Integer> trucks = List.of(4, 5, 7, 2);
        //List<Integer> items = List.of(1, 2, 5);

      //  List<Integer> trucks = List.of(5,3,8,1);
       // List<Integer> items = List.of(6,10);

         List<Integer> trucks = List.of(1,3,5,2,3,2);
         List<Integer> items = List.of(1, 2, 3);

        List<Integer> result = findTruckIndices(trucks, items);

        System.out.println("Result is: " + result);
    }
}
