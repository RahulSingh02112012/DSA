package Tree.Amazon;

import java.util.*;
import java.util.Map;
import java.util.TreeMap;

public class Comdy {
    public static int solutionB(List<Integer> A1, List<Integer> A2, List<Integer> B1, List<Integer> B2) {
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
        int minAInd = -1, minBInd = -1;

        // Find genre A's earliest finishing movie
        for (int i = 0; i < A1.size(); i++) {
            if (A1.get(i) + A2.get(i) < minA) {
                minA = A1.get(i) + A2.get(i);
                minAInd = i;
            }
        }

        // Find genre B's earliest finishing movie
        for (int i = 0; i < B1.size(); i++) {
            if (B1.get(i) + B2.get(i) < minB) {
                minB = B1.get(i) + B2.get(i);
                minBInd = i;
            }
        }

        int res = Integer.MAX_VALUE;

        // Get the total finish time assuming we take A's earliest + every B
        for (int j = 0; j < B1.size(); j++) {
            if (A1.get(minAInd) <= B1.get(j) - A2.get(minAInd)) {
                res = Math.min(res, B1.get(j) + B2.get(j));
            } else if (A1.get(minAInd) < B1.get(j) && minA > B1.get(j)) {
                res = Math.min(res, minA + B2.get(j));
            } else if (B1.get(j) <= A1.get(minAInd) - B2.get(j)) {
                res = Math.min(res, minA);
            } else {
                res = Math.min(res, B1.get(j) + B2.get(j) + A2.get(minAInd));
            }
        }

        // Get the total finish time assuming we take B's earliest + every A
        for (int j = 0; j < A1.size(); j++) {
            if (B1.get(minBInd) <= A1.get(j) - B2.get(minBInd)) {
                res = Math.min(res, A1.get(j) + A2.get(j));
            } else if (B1.get(minBInd) < A1.get(j) && minB > A1.get(j)) {
                res = Math.min(res, minB + A2.get(j));
            } else if (A1.get(j) <= B1.get(minBInd) - A2.get(j)) {
                res = Math.min(res, minB);
            } else {
                res = Math.min(res, A1.get(j) + A2.get(j) + B2.get(minBInd));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> A1 = Arrays.asList(1,4);
        List<Integer> A2 = Arrays.asList(3, 2);
        List<Integer> B1 = Arrays.asList(5, 2);
        List<Integer> B2 = Arrays.asList(2,2);

        int result = solutionB(A1, A2, B1, B2);

        System.out.println("Result is: " + result);
    }
}
