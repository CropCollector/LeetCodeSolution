package leetcode.editor.cn;

//Java：黄金矿工
public class PathWithMaximumGold {
    public static void main(String[] args) {
        Solution solution = new PathWithMaximumGold().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int ans = -1;

        public int getMaximumGold(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(grid, i, j, 0, new boolean[m][n]);
                }
            }
            return ans;
        }

        private void dfs(int[][] grid, int i, int j, int sum, boolean[][] flag) {
            if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) {
                ans = Math.max(ans, sum);
                return;
            }
            if (flag[i][j]) {
                return;
            }
            flag[i][j] = true;
            sum += grid[i][j];
            dfs(grid, i + 1, j, sum, flag);
            dfs(grid, i - 1, j, sum, flag);
            dfs(grid, i, j + 1, sum, flag);
            dfs(grid, i, j - 1, sum, flag);
            flag[i][j] = false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}