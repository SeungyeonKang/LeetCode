class Solution {
    public int scoreOfParentheses(String s) {
        
	//TC : O(n)
	//SC : O(n)
	Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if('(' == s.charAt(i)) stack.push('(');
            else {
                int sum = 0;
                while(stack.peek()!='(') {
                    sum+=stack.pop() - '0';
                }
                stack.pop();
                sum*=2;
                if(sum == 0) sum = 1;
                stack.push((char)(sum + '0'));
            }
        }
        
        int res = 0;
        while(!stack.isEmpty()) {
            res+=stack.pop() -'0';
        }
        return res;
    }
}
