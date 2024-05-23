package Tree.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeakElementFinderModified {
    static int res = -1;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        // int[] nums = {1, 2, 3, 1};
       // int[] nums = {10, 2, 1, 3, 5, 6,12};
        int[] nums = {10, 2, 1, 3, 5, 6};
        List<Integer> peakIndexes1 = findPeakElements(nums);
        List<Integer> peakIndexes = findPeakElements(nums);
        System.out.println("Peak elements indexes List: " + peakIndexes1);
        System.out.println("Peak elements indexes element: " + map.get(res));
    }

    public static List<Integer> findPeakElements(int[] nums) {
        List<Integer> peakIndexes = new ArrayList<>();

        findPeakElement(nums, 0, nums.length - 1, map);
        findPeakList(nums, 0, nums.length - 1, peakIndexes);
        return peakIndexes;
    }

    private static void findPeakElement(int[] nums, int left, int right, Map<Integer, Integer> map) {
        if (left > right) {
            return;
        }

        int mid = left + (right - left) / 2;

        if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
            if (nums[mid] > res) {
                res = nums[mid];
            }
            map.put(nums[mid], mid);
        }

        findPeakElement(nums, left, mid - 1, map);
        findPeakElement(nums, mid + 1, right, map);
    }

    private static void findPeakList(int[] nums, int left, int right, List<Integer> peakIndexes) {
        if (left > right) {
            return;
        }

        int mid = left + (right - left) / 2;

        if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
            if (nums[mid] > res) {
                res = nums[mid];
            }
            peakIndexes.add(mid);
        }

        findPeakList(nums, left, mid - 1, peakIndexes);
        findPeakList(nums, mid + 1, right, peakIndexes);
    }
}
