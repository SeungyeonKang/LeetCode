class Solution {
    public int countBinarySubstrings(String s) {
        /*
         연속하는 0과 1로 이루어진 부분 집합의 합 -> 중복 가능
         (ex) 00110011
         - 문자열이 반전 될때, Min(이전에 누적된 연속된 문자의 수, 반전된 연속된 문자 수) 만큼의 부분집합이 생김
         - 0011 
            - 0(2) 1(2) : 2 (01, 0011)
         (ex) 10101
         - 1(1) 0(1) : sum++
         - 0(1) 1(1) : sum++
         - 1(1) 0(1) : sum++
         - 0(1) 1(1) : sum++
         
         sum = 0 //누적된 연속된 0,1로 이루어진 부분문자열의 갯수
         prev_sum=0 //이전에 누적된 연속된 문자열의 갯수
         cur_sum=0 //현재까지 연속된 문자열의 갯수
         for(i:s.length-1)
            - cur_sum++;
            - if(s.charAt(i)!=s.charAt(i+1))
                - sum += Min(prev_sum, cur_sum);
                - prev_sum = cur_sum
                - cur_sum = 0;
        sum+=Math.min(prev, cur+1)
                
        Time Complexity = O(n)
        Space Complexity = O(1)
        */
        
        int sum = 0;
        int prev=0, cur=0;
        
        for(int i=0;i<s.length()-1;i++){
            cur++;
            if(s.charAt(i) != s.charAt(i+1)) {
                sum += Math.min(prev, cur);
                prev = cur;
                cur = 0;
            }
        }
        
        return sum+Math.min(prev, cur+1);
    }
}
