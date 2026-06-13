class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int m = triangle.size();

        int[] dp = new int[m];

        dp[0] = triangle.get(0).get(0);

        for(int i = 1; i < m; i++) {

            // Rightmost element
            dp[i] = dp[i - 1] + triangle.get(i).get(i);

            // Middle elements
            for(int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1])
                        + triangle.get(i).get(j);
            }

            // Leftmost element
            dp[0] = dp[0] + triangle.get(i).get(0);
        }

        int ans = Integer.MAX_VALUE;

        for(int num : dp) {
            ans = Math.min(ans, num);
        }

        return ans;
    }
}