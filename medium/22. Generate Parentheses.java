class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, "", 0, 0, n);
        return result;
    }

    void backtracking (List<String> result, String str, int s, int e, int max) {
        if(str.length() == max*2) {
            result.add(str);
            return;
        }
        
        if(s<max) backtracking(result, str + "(", s+1, e, max);
        if(e<s) backtracking(result, str + ")", s, e+1, max);
    }
}
