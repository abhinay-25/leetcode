class Solution {

    int[][] dp;

    public boolean canPartition(int[] nums) {

        int n = nums.length;

        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }

        dp = new int[n][sum/2 + 1];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return check(nums, n - 1, 0, sum / 2);
    }

    public boolean check(int[] nums, int index, int sum, int halfsum){

        if(sum == halfsum){
            return true;
        }

        if(index < 0){
            return false;
        }

        if(dp[index][sum] != -1){
            return dp[index][sum] == 1;
        }

        boolean nottake = check(nums, index - 1, sum, halfsum);

        boolean take = false;

        if(sum + nums[index] <= halfsum){
            take = check(nums,
                         index - 1,
                         sum + nums[index],
                         halfsum);
        }

        boolean ans = take || nottake;

        dp[index][sum] = ans ? 1 : 0;

        return ans;
    }
}