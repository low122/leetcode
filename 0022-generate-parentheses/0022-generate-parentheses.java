class Solution {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, "");
        return result;
    }


    void backtrack(int openN, int closeN, int n, String path) {

        // Base case:
        if (path.length() == (2*n)) {
            result.add(path);
            return;
        }

        if (openN < n) {
            path += "(";
            backtrack(openN+1, closeN, n, path);
            path = path.substring(0, path.length() - 1);
        }

        if (openN > closeN) {
            path += ")";
            backtrack(openN, closeN + 1, n, path);
            path = path.substring(0, path.length() - 1);
        }
    }
}