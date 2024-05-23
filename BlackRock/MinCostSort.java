package Tree.BlackRock;

import java.util.Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostSort {

    public static int minCostToSort(int[] arr) {
        int cost = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                cost += arr[i - 1] - arr[i];
                arr[i] = arr[i - 1];
            }
        }
        return cost;
    }

    public static long calculateCost(int[] array) {
        int n = array.length;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        q.add(-array[0]);
        long ans = 0;
        for (int i = 1; i < n; ++i) {
            int curr = -(array[i] - i);
            if (q.peek() < curr) {
                ans += curr - q.poll();
                q.add(curr);
            }
            q.add(curr);
        }
        return ans;
    }

    static long[][] f;

    public static long calculateMinimumCost(int[] a) {
        int n = a.length - 1; // Number of elements
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = a[i] - i;
            a[i] -= i;
        }
        Arrays.sort(b, 1, n + 1);
        int k = 1;
        for (int i = 2; i <= n; i++) {
            if (b[i] != b[i - 1]) {
                b[++k] = b[i];
            }
        }
        f = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], Long.MAX_VALUE);
        }
        for (int j = 1; j <= k; j++) {
            f[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            long Min = Long.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                Min = Math.min(Min, f[i - 1][j]);
                f[i][j] = Min + Math.abs(a[i] - b[j]);
            }
        }
        long ans = f[n][1];
        for (int i = 2; i <= k; i++) {
            ans = Math.min(ans, f[n][i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 5};
        int[] arr1 = {0, 1, 2, 5, 6, 6, 7};
        int[] arr2 = {0, 1, 2, 5, 6, 5, 7};
        int[] arr3 = {0, 2, 4, 8, 4, 5};
        int[] arr4 = {10, 9, 1, 2, 3};

       /* int minCost = minCostToSort(arr);
        int minCost1 = minCostToSort(arr1);
        int minCost2 = minCostToSort(arr2);
        int minCost3 = minCostToSort(arr3);
        int minCost4 = minCostToSort(arr4);*/

       /* long minCost = calculateCost(arr);
        long minCost1 = calculateCost(arr1);
        long minCost2 = calculateCost(arr2);
        long minCost3 = calculateCost(arr3);
        long minCost4 = calculateCost(arr4);*/

        //calculateMinimumCost

        long minCost = calculateMinimumCost(arr);
        long minCost1 = calculateMinimumCost(arr1);
        long minCost2 = calculateMinimumCost(arr2);
        long minCost3 = calculateMinimumCost(arr3);
        long minCost4 = calculateMinimumCost(arr4);

        System.out.println("Minimum cost to sort the array: " + minCost);
        System.out.println("Minimum cost to sort the array: " + minCost1);
        System.out.println("Minimum cost to sort the array: " + minCost2);
        System.out.println("Minimum cost to sort the array: " + minCost3);
        System.out.println("Minimum cost to sort the array: " + minCost4);
    }
}



