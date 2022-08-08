class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int x = 0; int y = 0;
        int[][] result = new int[r][c];
        int n= mat.length, m = mat[0].length;
        
        if(r*c != n * m) return mat;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                result[x][y++] = mat[i][j];
                if(y==c) {
                    y=0;
                    x++;
                } 
            }
        }
        return result;
    }
}
