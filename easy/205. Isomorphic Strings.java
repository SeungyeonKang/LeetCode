class Solution {
    public boolean isIsomorphic(String s, String t) {
        //TC : O(n)
        //SC : O(1)
        /*
         중요한 것은 같은 문자열이 나왔을때, 이전에 사용되었던 문자열의 자리가 동일하면 동일하게 치환 가능하다는 말이고,
         자리가 다르다면 각각 다른 문자열로 치환된다는 뜻이기 때문에 isIsomorphic 하지 않는다.
        */
        
        int len = s.length();
        int[] m1 = new int[256] , m2 = new int[256];
        
        for(int i=0;i<len;i++){
            if(m1[s.charAt(i)]!=m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i+1;
            m2[t.charAt(i)] = i+1;
        }
        return true;
    }
}
