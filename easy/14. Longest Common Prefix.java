class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*
          longest prefix.length <= strs[] 안의 문자열 중에 가장 짧은 문자열의 길이
          모든 문자열이 해당 문자열을 포함하고 있어야 함
          하나의 문자열을 초기 prefix로 잡고, 해당 문자열과 다른 문자열들과 비교하면서 공통 prefix로 좁혀감

          prefix = strs[0].length 
          for(i=1;i<strs.length; i++) 
            - if(strs[i].length(i) == 0) return ""
            - for(j=0; j<Min(prefix,strs[i].length); j++){
                - if strs[0].charAt(j) != str[i].charAt(j) 
                    - prefix = j;
                    - break;
          strs.substring(0,j);
          
          Time Complexity : O(mn) m : prefix length, n : input arrays' length
          Space Complexity : O(1)
    */   
        
        int prefix = strs[0].length(); 
        if(prefix == 0) return "";
        
        for(int i=1;i<strs.length; i++){
            prefix = Math.min(prefix, strs[i].length());
            
            for(int j=0;j<prefix; j++){
                if(strs[0].charAt(j)!=strs[i].charAt(j)) {
                    prefix = j;
                    break;
                }
            }
        }
        
        return strs[0].substring(0,prefix);
    }
     
}
