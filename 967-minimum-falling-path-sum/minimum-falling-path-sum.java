class Solution {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        // dp[r][c] = minimum falling path sum starting from (r, c)
        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int minSum = Integer.MAX_VALUE;

        // Try every column in the first row as a starting point
        for (int col = 0; col < n; col++) {
            minSum = Math.min(
                minSum,
                findSum(0, col, matrix, dp)
            );
        }

        return minSum;
    }

    private int findSum(int r, int c, int[][] matrix, int[][] dp) {

        int n = matrix.length;

        // Invalid column -> return a very large value
        if (c < 0 || c >= n) {
            return Integer.MAX_VALUE / 2;
        }

        // Last row reached
        if (r == n - 1) {
            return matrix[r][c];
        }

        // Already computed
        if (dp[r][c] != Integer.MAX_VALUE) {
            return dp[r][c];
        }

        int down = matrix[r][c] + findSum(r + 1, c, matrix, dp);

        int downLeft = matrix[r][c] + findSum(r + 1, c - 1, matrix, dp);

        int downRight = matrix[r][c] + findSum(r + 1, c + 1, matrix, dp);

        return dp[r][c] = Math.min(down,Math.min(downLeft, downRight));
    }
}