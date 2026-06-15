class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        return helper(n - 1, 0, nums, target);
    }

    public int helper(int index, int sum, int[] nums, int target) {

        if(index == 0){

            if(sum + nums[0] == target &&
               sum - nums[0] == target){
                return 2;
            }

            if(sum + nums[0] == target ||
               sum - nums[0] == target){
                return 1;
            }

            return 0;
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

        return pickplus + pickminus;
    }
}