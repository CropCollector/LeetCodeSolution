package leetcode.editor.cn;

//Java：边界着色
public class ColoringABorder {
    public static void main(String[] args) {
        Solution solution = new ColoringABorder().new Solution();
        // TO TEST
        System.out.println(solution.colorBorder(new int[][]{{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}}, 1, 3, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[][] grid;

        private int m, n;

        private boolean[][] flag;

        private int initColor;

        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            this.grid = grid;
            this.m = grid.length;
            this.n = grid[0].length;
            this.flag = new boolean[m][n];
            this.initColor = grid[row][col];
            dfs(row, col);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] < 0) {
                        grid[i][j] = color;
                    }
                }
            }
            return grid;
        }

        private void dfs(int row, int col) {
            if (row < 0 || row == m || col < 0 || col == n) {
                return;
            }
            if (flag[row][col]) {
                return;
            }
            flag[row][col] = true;

            if (initColor != grid[row][col]) {
                return;
            }
            if (row == 0 || row == m - 1 || col == 0 || col == n - 1) {
                grid[row][col] = -initColor;
            } else {
                if (Math.abs(grid[row][col + 1]) != initColor || Math.abs(grid[row][col - 1]) != initColor ||
                        Math.abs(grid[row + 1][col]) != initColor || Math.abs(grid[row - 1][col]) != initColor) {
                    grid[row][col] = -initColor;
                }
            }
            dfs(row, col + 1);
            dfs(row, col - 1);
            dfs(row + 1, col);
            dfs(row - 1, col);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}