class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        /*
          1) 두 문자열이 동일한 경우 => 중복으로 나오는 문자열이 있는 경우는 swap 가능
           - set에 모든 문자열을 넣음
           - set의 길이가 문자열의 길이보다 작으면 중복되는 문자열 있음 -> swap 가능
           
          2) 두 문자열이 동일하지 않은 경우 => 두 가지 문자열만 다르고, 다른 문자열이 동일한 경우 swap 가능
           - 다른 문자열을 list에 넣음
           - list size가 2이고, 두 문자열이 s와 goal에 서로 위치가 바뀌어있으면 swap 가능
           
          TC : O(n)
          SC : O(n)
        */
        
        Set<Character> set = new HashSet<Character>();
        int len = s.length();
        
        if(len != goal.length()) return false;
        
        if(s.equals(goal)) {
            for(int i=0;i<len;i++){
                set.add(s.charAt(i));
            }
            return set.size() < len;
        } 
        
        List<Integer> diff = new ArrayList<>();
        for(int i=0;i<len;i++) {
            if(s.charAt(i)!=goal.charAt(i)) {
                diff.add(i);
            } 
        }
        return diff.size() == 2 
            && s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) 
            && s.charAt(diff.get(1)) == goal.charAt(diff.get(0));
    }
}
