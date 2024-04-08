package Tree.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class PreviousGreaterElement {

    public static void main(String[] args) {
        int[] input = new int[] {13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
        int[] res = previousGreaterElement(input);

        System.out.println(Arrays.stream(input).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));

    }

    private static int[] previousGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        Arrays.fill(res,-1);

        for(int i =0;i< nums.length;i++) {
            while(!stk.isEmpty() && nums[stk.peek()] <= nums[i]) {
                stk.pop();
            }
            if(!stk.isEmpty()) {
                res[i] = nums[stk.peek()];
            }
            stk.push(i);
        }
        return res;
    }
}
