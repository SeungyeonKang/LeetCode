class Solution {
    //TC : O(n)
    //SC : O(n)
    public boolean canConstruct(String s, int k) {
        if(s.length() == k) return true;
        if(s.length() < k ) return false;
        
        /*
        palindrome = palindrome + 같은 문자 2개
        홀수인 문자 1개, 같은 문자 2개 묶음 or 짝수인 문자 2개 묶음
        홀수인 문자 갯수 <= k, 나머지 짝수 
        */
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }
        
        int odd = 0;
        for(char key : map.keySet()) {
            if(map.get(key) % 2 == 1) odd++;
        }
        
        if(odd<=k) return true;
        else return false;
    }
}
