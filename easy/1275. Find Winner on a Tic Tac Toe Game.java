class Solution {
    public String tictactoe(int[][] moves) {
        /*
        1. 행, 열, 대각선 중 3개가 동일한 문자이면 승리
           - 가능한 행의 갯수 = 3개
           - 가능한 열의 갯수 = 3개
           - 가능한 대각선의 갯수 = 2개
           => 한 행 또는 한 열 또는 한 대각선을 기준으로 3칸을 갖고 있으면 됨
        2. 승부가 나지 않았는데, 사각형이 꽉찼으면 draw
        3. 승부가 나지 않았고, 사각형이 비어있으면 pending
        */
        
        //각 플레이어의 각 행, 열, 대각선에 위치하는 해당 플레이어의 문자열 갯수를 저장
        int[] A = new int[8], B = new int[8];
        
        for(int i=0;i<moves.length; i++){
            int y = moves[i][0], x = moves[i][1];
            int[] player = i%2==0 ? A : B;
            player[y]++;
            player[x+3]++;
            if(y==x) player[6]++;
            if(y==2-x) player[7]++;
        }
        
        for(int i=0; i<8;i++){
            if(A[i]==3) return "A";
            else if (B[i]==3) return "B";
        }
        
        if(moves.length == 9) return "Draw";
        else return "Pending";
        
    }
    
    //시간 복잡도 : O(n+8) -> O(n)
    //공간 복잡도 : O(16) -> O(1)
    
}
