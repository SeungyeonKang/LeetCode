class Solution {
    public void rotate(int[][] matrix) {
        /* 
        [i][j] -> [j][n-i] -> [n-i][m-j] -> [m-j][i]
        
        [0][0] -> [0][3] -> [3][3] -> [3][0] -> [0][0]
        [0][1] -> [1][3] -> [3][2] -> [2][0] -> [0][1]
        [0][2] -> [2][3] -> [3][1] -> [1][0] -> [0][2]
        
        [1][1] -> [1][2] -> [2][2] -> [2][1] -> [1][1]
        
        TC : O(nm)
        SC : O(1)
        */

        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i=0;i<n/2; i++) {
            for(int j=i; j<m-i-1;j++){
                int tmp = matrix[i][j];
                matrix[i][j]  = matrix[m-j-1][i];
                matrix[m-j-1][i] = matrix[n-i-1][m-j-1];
                matrix[n-i-1][m-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
}
