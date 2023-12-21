package Tree.QuestionOfTheDay;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RangeAddition_370 {
    // Similar to temple problem asked in VM ware
    public static void main(String[] args) {
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        System.out.println(Arrays.stream(getRangeSum(5,updates)).toArray());
    }

    private static int[] getRangeSum(int length, int[][] updates) {
        int[] res = new int[length];

        for(int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];

            res[start] += val;

            if(end < length -1) {
                res[end+1] -=val;
            }
        }

        for(int i = 1;i<length;i++){
            res[i] = res[i]+res[i-1];
        }

        return res;
    }
}
