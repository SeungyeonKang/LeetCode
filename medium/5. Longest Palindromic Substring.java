class Solution {
    int result_s, result_e;
    int maxLength=0;
    
    public String longestPalindrome(String s) {
        /*
         팰린드롬 : 팰린드롬 단어 +1 자리와 팰린드롬 단어 -1 자리의 문자가 동일하면 확장 가능
         0**0 인 케이스 0*&*0인 케이스
         Time Complexity : O(n^2)
         Space Complexity : O(1)
        */
        
        int len = s.length();
        if(len==1) return s;
        
        for(int i=0; i<len-1;i++) {
            expand(s, i,i);
            expand(s,i,i+1);
        }
        return s.substring(result_s,result_e+1);
    }
    
    void expand(String s, int start, int end) {
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)) {
            if(end-start+1 > maxLength) {
                maxLength = end-start+1;
                result_s = start;
                result_e = end;
            }
            start--;
            end++;
        }
    }
}
