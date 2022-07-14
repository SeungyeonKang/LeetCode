class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //TC : O(m+n)
        //SC : O(1)
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        if(matrix == null || m < 1 || n <1) {
            return false;
        }
        
        int x = 0;
        int y = n-1;
        
        while(x<m && y>=0) {
            if(target > matrix[x][y]) {
                x=x+1;
            } else if(target < matrix[x][y]) {
                y=y-1;
            } else {
                return true;
            }
        }
        return false;
    }
}
