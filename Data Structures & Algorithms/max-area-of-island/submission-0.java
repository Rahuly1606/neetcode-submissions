class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] visited = new boolean[n][m];
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    max = Math.max(max, dfs(i, j, visited, grid));
                }
            }
        }
        return max;
    }
    public static int dfs(int i, int j, boolean [][] visited, int [][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) return 0;

        visited[i][j] = true;
        int cnt = 1;
        cnt += dfs(i - 1, j, visited, grid);
        cnt += dfs(i + 1, j, visited, grid);
        cnt += dfs(i, j - 1, visited, grid);
        cnt += dfs(i, j + 1, visited, grid);
        return cnt;
    }
}
