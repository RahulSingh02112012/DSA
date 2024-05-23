package Tree.BlackRock;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SortWithMinCost {
    public static void main(String[] args) {
           /* Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            PriorityQueue<Integer> q = new PriorityQueue<Integer>();
            q.add(-in.nextInt());
            long ans = 0;
            for (int i = 1; i < n; ++i) {
                int curr = -(in.nextInt() - i);
                if (q.peek() < curr) {
                    ans += curr - q.poll();
                    q.add(curr);
                }
                q.add(curr);
            }
            System.out.println(ans);*/
        System.out.println(calculatePriorityQueueSum(new int[]{0,1,2,5,6,5,7}));
        System.out.println(calculatePriorityQueueSum(new int[]{5,4,3,2,1}));
        }

    public static long calculatePriorityQueueSum(int[] arr) {
        long ans = 0;
        PriorityQueue<Integer> Q = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        Q.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int a = arr[i] - i;
            Q.add(a);

            if (Q.peek() >= a) {
                ans += Q.peek() - a;
                Q.poll();
                Q.add(a);
            }
        }
        return ans;
    }

    }

