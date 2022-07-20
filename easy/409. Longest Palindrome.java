class Solution {
    public int longestPalindrome(String s) {
        //TC : O(n);
        //SC : O(n);
        Set<Character> set = new HashSet<>();
        int count=0;
        for(int i=0;i<s.length(); i++){
            if(set.contains(s.charAt(i))) {
                count++;
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        
        if(!set.isEmpty()) return count*2 +1;
        return count*2;
    }
}
