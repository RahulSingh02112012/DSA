package Tree.Zalando;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        Arrays.stream(nextGreaterElements(new int[]{1,2,3,4,3})).forEach(System.out::println);
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();

        int[] res = new int[nums.length];
        Arrays.fill(res,-1);

        for(int j=0;j<2;j++) {
            for(int i =0;i<nums.length;i++) {
                while(!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
                    res[stk.pop()]=nums[i];
                }
                stk.push(i);
            }
        }


        return res;
    }
}
