class Solution {
    public int minInsertions(String s) {
         return s.length()-longestPalindromeSubseq(s);
         
    }
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int n=s.length();
        return helper(s,r,n);
    }
    public int helper(String s,String r,int n){
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<n;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==r.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
    //    System.out.println(Arrays.deepToString(dp));
        return dp[n][n];
    }
}