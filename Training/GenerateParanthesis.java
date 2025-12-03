class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(ans, "", 0, 0, n);
        return ans;
    }

    private void solve(List<String> ans, String curr, int open, int close, int n) {
        // valid string complete
        if (curr.length() == 2 * n) {
            ans.add(curr);
            return;
        }

        // add '(' if allowed
        if (open < n) {
            solve(ans, curr + "(", open + 1, close, n);
        }

        // add ')' only if , wont won't break validity
        if (close < open) {
            solve(ans, curr + ")", open, close + 1, n);
        }
    }
}
