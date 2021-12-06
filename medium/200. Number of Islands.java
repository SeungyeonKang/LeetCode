class Solution {
    int[] x = {-1,0,0,1};
    int[] y = {0,-1,1,0};
    char[][] g;
    
    
    public int numIslands(char[][] grid) {
        //DFS 또는 BFS 사용
        //처음 시작점 grid[0][0] -> 위/아래/왼쪽/오른쪽 탐색하며 해당 방향의 값이 1인 경우 재 탐색
        //해당 지점을 통과했는지 여부를 표시해야함 "2 : 방문한 정점"
        //Time Complexity : O(mn)
        //Space Complexity : O(mn)
        
        
        g=grid;
        int numberOfIsland = 0;
        for(int i=0;i<g.length;i++){
            for(int j=0;j<g[0].length;j++){
                if(g[i][j]=='1') {
                    dfs(i, j);
                    numberOfIsland++;
                }
            }
        }
        return numberOfIsland;
    }
    
    void dfs(int curX, int curY) {
        g[curX][curY] = '2';
        
        for(int i=0;i<4;i++){
            int nextX = curX + x[i];
            int nextY = curY + y[i];
            
            if((nextX >=0 && nextX<g.length) 
               && (nextY>=0 && nextY<g[0].length) 
               && g[nextX][nextY]=='1') {
                dfs(nextX,nextY);
            }
        }
    }
}
