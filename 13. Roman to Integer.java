class Solution {
    public int romanToInt(String s) {
        /*
        s = 가장 큰 수 -> 가장 작은 수, 각 수들을 더한 값이 int 형의 결과값
        order가 작은 숫자 기호 + 큰 숫자 기호 (6가지 예외 경우이면) = 큰 숫자 - 작은 숫자를 뺀 하나의 숫자
        (ex) MCMXCIV
        M : 1000, C : 100(X), CM : 900, X : 10(x), XC : 90, I : 1(X), IV : 5
        for(cur : s.length-1)
         if( 현재 인덱스 (cur) 값이 다음 인덱스 값 보다 작다면 )
            - sum-=values[cur];
         else 
            - sum+=values[cur];
        return sum+values[length-1];
        
        Time Complexity : O(n)
        Space Complexity : O(1)
        */
        int sum = 0;
        
        for(int i=0; i<s.length()-1; i++){
            int cur = getValue(s.charAt(i));
            if(cur < getValue(s.charAt(i+1))) sum-=cur;
            else sum += cur;
        }
        
        return sum+getValue(s.charAt(s.length()-1));
    }
    
    private int getValue(char c) {
        if(c == 'I') return 1;
        else if(c == 'V') return 5;
        else if(c == 'X') return 10;
        else if(c == 'L') return 50;
        else if(c == 'C') return 100;
        else if(c == 'D') return 500;
        return 1000;
    }
}
