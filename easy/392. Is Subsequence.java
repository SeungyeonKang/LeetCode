class Solution {
    public boolean isSubsequence(String s, String t) {
        /*
        for a=0, b=0:
            if(s.charAt(a) == t.charAt(b)) : 
                해당 문자는 통과 => a++, b++
            else
                b++
            
            if(a==s.length()) : 문자열들이 순서대로 t에 존재한다는 의미이므로  
                    return true
        */
        //TC : O(n)
        //SC : O(1)
        
        int a=0, b=0;
        int sLen = s.length(), tLen = t.length();
        
        while(a<sLen && b<tLen) {
            if(s.charAt(a) == t.charAt(b)) {
                a++;
                b++;
            } else 
                b++;
        }
        if(a==s.length()) return true;
        else return false;
    }
}
