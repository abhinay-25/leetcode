class Solution {

    public int[] sumAndMultiply(String s, int[][] queries) {

        final int MOD = 1_000_000_007;
        int n = s.length();

        // prefix sum of non-zero digits
        int[] prefixSum = new int[n + 1];

        // powers of 10
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // prefix hash of non-zero digits
        long[] prefixNum = new long[n + 1];
        int[] prefixCount = new int[n + 1];

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            prefixSum[i + 1] = prefixSum[i];
            prefixNum[i + 1] = prefixNum[i];
            prefixCount[i + 1] = prefixCount[i];

            if (ch != '0') {
                int digit = ch - '0';

                prefixSum[i + 1] += digit;

                prefixNum[i + 1] =
                        (prefixNum[i] * 10 + digit) % MOD;

                prefixCount[i + 1]++;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int digitSum =
                    prefixSum[r + 1] - prefixSum[l];

            int cnt =
                    prefixCount[r + 1] - prefixCount[l];

            long left =
                    (prefixNum[l] * pow10[cnt]) % MOD;

            long x =
                    (prefixNum[r + 1] - left + MOD) % MOD;

            ans[i] = (int) ((x * digitSum) % MOD);
        }

        return ans;
    }
}