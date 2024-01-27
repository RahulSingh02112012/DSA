package Tree.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Recursively sort the first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // Calculate sizes of two subarrays to be merged
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[sizeLeft];
        int[] rightArray = new int[sizeRight];

        // Copy data to temporary arrays
        for (int i = 0; i < sizeLeft; ++i) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < sizeRight; ++j) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Merge the temporary arrays

        // Initial indices of the first and second subarrays
        int i = 0, j = 0;

        // Initial index of the merged subarray
        int k = left;
        while (i < sizeLeft && j < sizeRight) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[], if any
        while (i < sizeLeft) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[], if any
        while (j < sizeRight) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

