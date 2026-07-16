class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int[] prefixGcd=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            prefixGcd[i]=gcd(nums[i],max);
        }
        Arrays.sort(prefixGcd);
        int i=0;
        int j=n-1;
        long result=0;
        while(i<j){
            result+=gcd(prefixGcd[i],prefixGcd[j]);
            i++;
            j--;
        }
        return result;

    }
    int gcd(int num1,int num2){
        while(num2!=0){
            int temp=num2;
            num2=num1%num2;
            num1=temp;
        }
        return num1;
    }
}