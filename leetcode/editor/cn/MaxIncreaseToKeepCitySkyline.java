package leetcode.editor.cn;

import java.util.Arrays;

//Java：保持城市天际线
public class MaxIncreaseToKeepCitySkyline {
    public static void main(String[] args) {
        Solution solution = new MaxIncreaseToKeepCitySkyline().new Solution();
        // TO TEST
        System.out.println(solution.maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int len = grid.length;
            int[] row = new int[len];
            int[] col = new int[len];
            for (int i = 0; i < len; i++) {
                int maxRow = 0, maxCol = 0;
                for (int j = 0; j < len; j++) {
                    if (grid[i][j] > maxRow) {
                        maxRow = grid[i][j];
                    }
                    if (grid[j][i] > maxCol) {
                        maxCol = grid[j][i];
                    }
                }
                row[i] = maxRow;
                col[i] = maxCol;
            }

            int ans = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    ans += Math.min(row[i], col[j]) - grid[i][j];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}