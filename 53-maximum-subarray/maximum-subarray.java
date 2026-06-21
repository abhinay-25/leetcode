class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        int lock=0;
        for(int num:nums){
            
            if(sum + num<0){
                sum=0;
            }
            else{
                sum+=num;
                max=Math.max(max,sum);
                lock=1;
            }
        }
        int max1=Integer.MIN_VALUE;
        if(lock==0){
            for(int num:nums){
                max1=Math.max(max1,num);
            }
            return max1;
        }
        return max==Integer.MIN_VALUE?-1 : max;
    }
}