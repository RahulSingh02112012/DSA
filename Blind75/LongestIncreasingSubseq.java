package Tree.Blind75;

import java.util.Arrays;

public class LongestIncreasingSubseq {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(s.substring(0,4));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        if(nums.length == 1) {
            return 1;
        }
        if(nums.length== 2) {
            if(nums[0]<nums[1]) {
                return 2;
            }
        }

        Arrays.fill(dp,1);
        int ans=1;
        for(int i= 1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i]= Math.max(dp[i], 1+dp[j]);
                    ans = Math.max(ans,dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
