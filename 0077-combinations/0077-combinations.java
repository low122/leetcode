class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(new ArrayList<>(), n, k, 1);
        return result;    
    }

    void backtrack(List<Integer> path, int n, int k, int start) {

        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(path, n , k, ++start);
            path.remove(path.size()-1);
        }
    }


}