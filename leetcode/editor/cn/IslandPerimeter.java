package leetcode.editor.cn;

//Java：岛屿的周长
public class IslandPerimeter {
    public static void main(String[] args) {
        Solution solution = new IslandPerimeter().new Solution();
        // TO TEST
        System.out.println(solution.islandPerimeter(new int[][]{{0, 1}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (i == 0 || grid[i - 1][j] == 0) {
                    ans ++;
                }
                if (i == m - 1 || grid[i + 1][j] == 0) {
                    ans ++;
                }
                if (j == 0 || grid[i][j - 1] == 0) {
                    ans ++;
                }
                if (j == n - 1 || grid[i][j + 1] == 0) {
                    ans ++;
                }
             }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}