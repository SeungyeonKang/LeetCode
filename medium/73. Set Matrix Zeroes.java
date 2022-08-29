class Solution {
    
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        //1<=m,n<=200
        //constant space solution
        List<int[]> list = new ArrayList<>();
        
        for(int i=0;i<m; i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0) list.add(new int[]{i,j});
            }
        }
        
        for(int i=0;i<list.size();i++){
            int[] tmp = list.get(i);
            int x = tmp[0];
            int y = tmp[1];
            //right
            for(int j=tmp[1]+1;j<n;j++){
                matrix[x][j] = 0;
            }
                
            //left
            for(int j=tmp[1]-1; j>=0; j--){
                matrix[x][j] = 0;
            }
            //bottom
            for(int j=tmp[0]+1;j<m;j++){
                matrix[j][y] = 0;
            }
            //top
            for(int j=tmp[0]-1; j>=0; j--){
                matrix[j][y] = 0;
            }
        }
        return;
    }
}
