class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        backtrack(path, candidates, target, 0, 0);
        return result;
    } 

    void backtrack(List<Integer> path, int[] candidates, int target, int index, int sum) {

        if (sum == target) {
            result.add(new ArrayList<>(path));
            sum = 0;
            return;
        }

        if (sum <= target) {
            for (int i = index; i < candidates.length; i++) {
                if (path.isEmpty() || path.get(path.size() - 1) <= candidates[i]) {
                    path.add(candidates[i]);
                    sum += candidates[i];
                    backtrack(path, candidates, target, index, sum);
                    path.remove(path.size() - 1);
                    sum -= candidates[i];
                }
            }
        }
    }
}