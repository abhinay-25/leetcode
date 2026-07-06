class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(0, target, candidates, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int start,
                           int target,
                           int[] candidates,
                           List<Integer> temp,
                           List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Remaining numbers are larger
            if (candidates[i] > target) {
                break;
            }

            temp.add(candidates[i]);

            backtrack(i + 1,
                      target - candidates[i],
                      candidates,
                      temp,
                      result);

            temp.remove(temp.size() - 1);
        }
    }
}