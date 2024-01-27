package Tree.Microsoft;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int patchPotholes(List<Integer> x, List<Integer> y, int w) {
        // Sort the list of pothole positions
        x.sort(null);

        int drives = 0;
        int i = 0;

        while (i < x.size()) {
            drives++;
            int target = x.get(i) + w + 1;

            while (i < x.size() && x.get(i) < target) {
                i++;
            }
        }

        return drives;
    }

    public static void main(String[] args) {
        // Example usage:
        Solution solution = new Solution();
        List<Integer> x = Arrays.asList(1, 3, 6, 10);
        List<Integer> y = Arrays.asList(0, 0, 0, 0); // Assuming y list is not used in the logic
        int w = 2;

        int result = solution.patchPotholes(x, y, w);
        System.out.println("Number of drives needed: " + result);
    }
}

