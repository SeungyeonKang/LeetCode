class Solution {
    public int uniqueLetterString(String s) {
        //TC : O(n)
        //SC : O(1)
        int[] contributions = new int[26];
        int[] showLastPosition = new int[26];
        
        if(s==null || s.length()==0) return 0;
        int res = 0;
        
        //initialize : -1 means ith alphabet is not in string
        for(int i=0;i<26;i++) {
            showLastPosition[i] = -1;
        }
        
        int cur = 0;
        for(int i=0; i<s.length(); i++){
            int idx = s.charAt(i)-'A';
            //at thie point, cur is cur(i-1) -> sum of uniq character count of substrings (0 ~ i-1)
            cur-=contributions[idx];
            
            //update contributions. It can affect if it's only unique character
            contributions[idx] = i-showLastPosition[idx];
            
            //add contributions count of this index's character
            cur+=contributions[idx];
            
            //update current idx to last position of the character
            showLastPosition[idx] = i;
            res+=cur;
        }
        return res;
    }
}
