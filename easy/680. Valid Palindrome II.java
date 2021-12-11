class Solution {
    
    //Time Complexity : O(n)
    //Space Complexity : O(1)
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return isPalindrome(s,left, right-1) || isPalindrome(s, left+1, right);
            left++;
            right--;
        }
        return true;
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while(left<right) {
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    
}
