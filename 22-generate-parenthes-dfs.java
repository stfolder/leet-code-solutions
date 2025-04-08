class Solution {
    List result = new ArrayList<String>();

    private void dfs(int lp, int rp, String s, int n) {
        if (s.length() == n * 2) {//if all paranthes are used we can add this combination to the result
            result.add(s);
            return;
        }

        // Try variant of adding '(' to existing combination
        if (lp < n) {  // We can not use more then n '(', so no need to go left branch for adding new '('
            dfs(lp + 1, rp, s + "(", n);
        }

        // Then try variant of adding ')' to the same combination
        if (rp < lp) { // we can add ')' only if there more '(' than ')'
            dfs(lp, rp + 1, s + ")", n);
        }

    }

    public List<String> generateParenthesis(int n) {
       dfs(0, 0, "", n);  // It serially adds '(' or ')' choosing both variants not breaking 2 rules until we get s having length of 2*n  
       return result;
    }
}
