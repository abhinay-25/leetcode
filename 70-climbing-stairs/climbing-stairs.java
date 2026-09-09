class Solution {
    public int climbStairs(int n) {
        
        if(n<=1){
            return n;
        }
        int dp1=1;
        int dp2=2;
        for(int i=2;i<n;i++){
            int res=dp1+dp2;
            dp1=dp2;
            dp2=res;

        }
        return dp2;
    }
}