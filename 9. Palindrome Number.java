class Solution {
    public boolean isPalindrome(int x) {
        /*
        palindrome 이라는 것은 뒤짚어도 동일한 숫자가 되게 하는 것
        x의 모듈러 연산을 통해 맨 뒷 자리부터 뽑고, 역순의 int 값을 만든 다음
        만들어진 값이 들어온 값과 동일한지 비교하여 찾을 수 있음
        이때 x는 누적하여 /10 되어야 하기 때문에 초기 x의 값을 저장해야함
        
        예외 조건 : x < 0 이면 무조건 false
        Time Complexity : O(n)
        Space Complexity : O(1)
        
        *개선 : 또는 x의 절반까지만 돈 후, reverse 값과 x값이 같은지 비교할 수 있음
         이때는 1.가운데를 기준으로 대칭인 펠린드롬, 2.기준 없이 대칭인 팰린드롬 두 가지 경우가 나올 수 있음
         Time Complexity : O(n/2) -> 
         Space Complexity : O(1)
        */
        
        if(x<0 || (x!=0 && x%10==0)) return false;
        
        int reverse = 0;
         while(x>reverse) {
             reverse = reverse * 10 + x%10;
             x/=10;
         }
        return (reverse==x || reverse/10 == x);
    }
}
