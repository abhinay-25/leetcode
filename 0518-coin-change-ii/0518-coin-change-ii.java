class Solution {
    private Integer[][] memo;

    public int change(int amount, int[] coins) {
        int n = coins.length;
        memo = new Integer[n + 1][amount + 1];
        return countWays(coins, n, amount);
    }

    private int countWays(int[] coins, int idx, int amt) {
        if (amt == 0) return 1;
        if (idx == 0) return 0;

        if (memo[idx][amt] != null) return memo[idx][amt];

        int skip = countWays(coins, idx - 1, amt);

        int take = 0;
        if (coins[idx - 1] <= amt)
            take = countWays(coins, idx, amt - coins[idx - 1]);

        return memo[idx][amt] = skip + take;
    }
}