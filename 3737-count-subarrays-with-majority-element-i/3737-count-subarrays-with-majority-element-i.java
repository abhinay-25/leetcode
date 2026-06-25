import java.util.*;

class Solution {

    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + (nums[i - 1] == target ? 1 : -1);
        }

        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        int idx = 1;

        for (int x : sorted) {
            if (!rank.containsKey(x))
                rank.put(x, idx++);
        }

        Fenwick bit = new Fenwick(idx + 2);

        int ans = 0;

        for (int x : prefix) {

            int r = rank.get(x);

            ans += bit.query(r - 1);

            bit.update(r, 1);
        }

        return ans;
    }

    static class Fenwick {

        int[] tree;

        Fenwick(int n) {
            tree = new int[n];
        }

        void update(int i, int val) {
            while (i < tree.length) {
                tree[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}