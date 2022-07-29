class Solution {
    //TC : O(mn)
    //SC : O(1)
    int n, m;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        
        m = image.length;
        n = image[0].length;
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    public void dfs(int[][] image, int x, int y, int color, int curColor) {
        if(x < 0 || x >= m || y < 0 || y >= n) return;
        if(image[x][y] != curColor) return;
        
        image[x][y] = color;
        
        dfs(image, x, y+1, color, curColor);
        dfs(image, x, y-1, color, curColor);
        dfs(image, x-1, y, color, curColor);
        dfs(image, x+1, y, color, curColor);
    }
}
