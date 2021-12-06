class Solution {
    public int climbStairs(int n) {
        // n : top까지 가는데 필요한 step수
        // 한번에 올라갈 수 있는 계단 수 : 1 or 2
        // 1<=n<=45 일때, 계단을 오를 수 있는 경우의 수
        // step[1] : 1, step[2] : 1 + 1, 2, step[3] : 1+1 +1, 2 + 1, 1+ 2
        // step[4] : 1+1+1+1, 1+2+1, 1+1+2, 2+1+1, 2+2
        // step[i] : i-2칸에서 +2 하는 경우의 수 + i-1칸에서 +1 하는 경우의 수
        // curStep = prevStep1 + prevStep2
        // Time Complexity : O(n)
        // Space Complexity : O(1)
        
        int prevStep2 = 1, prevStep1 = 2;
        
        if(n<3) return n;
        
        int curStep = 0;
        for(int i=3;i<=n;i++){
            curStep = prevStep1 + prevStep2;
            prevStep2 = prevStep1;
            prevStep1 = curStep;
        }
        return curStep;
    }
}

