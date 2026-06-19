class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] visited = new boolean[n][m];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    cnt++;
                    dfs(i, j, visited, grid);
                }
            }
        }
        return cnt;
    }
    public static void dfs(int i, int j, boolean [][] visited, char [][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') return;

        visited[i][j] = true;

        dfs(i - 1, j, visited, grid);
        dfs(i + 1, j, visited, grid);
        dfs(i, j - 1, visited, grid);
        dfs(i, j + 1, visited, grid);
    }
}
