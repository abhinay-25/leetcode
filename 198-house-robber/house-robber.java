class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] robbed=new int[n+1];
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Integer.max(nums[0],nums[1]);
        }
        robbed[0]=0;
        robbed[1]=nums[0];
        robbed[2]=Integer.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            robbed[i+1]=Integer.max(robbed[i],robbed[i-1]+nums[i]);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            if(robbed[i]>max){
                max=robbed[i];
            }
        }
        return max;
    }
}