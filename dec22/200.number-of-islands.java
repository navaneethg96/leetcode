/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

//      DFS Approach:    T - O(M * N)     S - O(M * N)

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y, int row, int col) {

        if (x < 0 || x > row - 1
        || y < 0 || y > col - 1
        || grid[x][y] != '1'
        ) {
            return;
        }


        if (grid[x][y] == '1') {
            grid[x][y] = '2';                   // To indicate that it is visited

            dfs(grid, x+1, y, row, col);        //Right Traversal
            dfs(grid, x-1, y, row, col);        //Left
            dfs(grid, x, y+1, row, col);        //Up
            dfs(grid, x, y-1, row, col);        //Down
        }
    }
}
// @lc code=end

