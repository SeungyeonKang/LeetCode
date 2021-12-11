class Solution {
    public boolean isPalindrome(String s) {
        /*
        1. 영숫자가 아닌 것 제거
        2. 팰린드롬의 조건 -> 팰린드롬 문자 + left + right가 팰린드롬이면 그 문자는 팰린드롬!
        3. 시작점 : 양 끝에서 시작해서 만날때까지 줄여옴
            - 중간에 left, right가 서로 다른 문자이면 false
            - left < right 일때까지 서로 같은 문자이면 true
            
        Time Complexity : O(n)
        Space Complexity : O(1)
        
        */
        
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");

        int left = 0, right = s.length()-1;
        while(left < right) {
            if(s.charAt(left)!=s.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }
}
