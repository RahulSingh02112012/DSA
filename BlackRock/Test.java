package Tree.BlackRock;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long ans = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> Integer.compare(y, x));


        while (n-- > 0) {
            int x = scanner.nextInt();
            x += n;
            q.add(x);
            if (q.peek() > x) {
                ans += q.peek() - x;
                q.poll();
                q.add(x);
            }
        }
        System.out.println(ans);
        scanner.close();
    }
}
