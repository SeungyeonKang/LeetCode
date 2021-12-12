class Solution {
    public int calculate(String s) {
        /*
            우선순위 : '+' '-' < '*' '/'
            - 스택에 쌓으면서 우선순위가 높은 연산자를 만나면 이전꺼 pop()해서 다음 숫자와 계산하고 넣기
            - 맨 처음과 마지막은 무조건 숫자
            - 연산자와 숫자가 아닌 문자도 있음 (' ')
            - 숫자는 십의자리까지 고려해야함
            - 앞의 숫자, 연산자, 뒤의 숫자를 구하고 계산하는 방식
            - 연산자에 도달했을때 이전전 숫자, 이전 연산자, 이전 숫자를 계산하면 됨
            
             Time Complexity : O(n)
             Space Complexity : O(n)
        */
        
        Stack<Integer> stack = new Stack<>();
        
        int num = 0;
        int len = s.length();
        char sign = '+';
        for(int i=0;i<len; i++){
            if(Character.isDigit(s.charAt(i))) num = num*10 + s.charAt(i)-'0';
            
            if((!Character.isDigit(s.charAt(i)) && ' '!=s.charAt(i)) || i==len-1) {
                if(sign == '-') stack.push(-num);
                else if(sign == '+') stack.push(num);
                else if(sign == '*') stack.push(stack.pop()*num);
                else stack.push(stack.pop()/num);
                
                sign = s.charAt(i);
                num = 0;
            }
        }
        
        int sum = 0;
        while(!stack.isEmpty()) {
            int tmp = stack.pop();
            sum+=tmp;
        }
        return sum;
    }
    
}
