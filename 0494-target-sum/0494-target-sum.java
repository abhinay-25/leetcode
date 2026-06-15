class Solution {

    Integer[][] dp;
    int offset;

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        offset = totalSum;

        dp = new Integer[n][2 * totalSum + 1];

        return helper(n - 1, 0, nums, target);
    }

    public int helper(int index,
                      int sum,
                      int[] nums,
                      int target) {

        if(dp[index][sum + offset] != null){
            return dp[index][sum + offset];
        }

        if(index == 0){

            int ans = 0;

            if(sum + nums[0] == target){
                ans++;
            }

            if(sum - nums[0] == target){
                ans++;
            }

            return dp[index][sum + offset] = ans;
        }

        int pickplus =
            helper(index - 1,
                   sum + nums[index],
                   nums,
                   target);

        int pickminus =
            helper(index - 1,
                   sum - nums[index],
                   nums,
                   target);

        return dp[index][sum + offset]
                = pickplus + pickminus;
    }
}