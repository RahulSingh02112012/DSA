package Tree.SlidingWindow;

import java.util.*;

public class LC2461_MaxSumDistintSubarraysOflenK {
    public static void main(String[] args) {

    }

        public static long maximumSubarraySum(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            int currSum = 0;
            int maxSum = Integer.MIN_VALUE;

            for(int i =0;i<k;i++) {
                if(!set.contains(nums[i])){
                    currSum += nums[i];
                    set.add(nums[i]);
                } else {
                    currSum = 0;
                }

            }

            maxSum = Math.max(maxSum,currSum);

            for(int i=k ; i<nums.length;i++) {
                if(!set.contains(nums[i])) {
                    currSum = currSum - nums[i-k] + nums[i];
                    maxSum = Math.max(currSum,maxSum);
                    set.add(nums[i]);
                    set.remove(nums[i-k]);
                }
            }

            return maxSum;
        }
    }

