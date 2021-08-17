package leetcode.editor.cn;

//Java：出界的路径数
public class OutOfBoundaryPaths {
    public static void main(String[] args) {
        Solution solution = new OutOfBoundaryPaths().new Solution();
        // TO TEST
        System.out.println(solution.findPaths(8,50,23,5,26));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 四个方向
    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    // 取余
    int MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // 缓存
        int[][][] memo = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return dfs(m, n, maxMove, startRow, startColumn, memo);
    }

    private int dfs(int m, int n, int moveCount, int i, int j, int[][][] memo) {
        // 越界了就找到了一条路径
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 1;
        }

        // 没有移动次数了，返回0
        if (moveCount == 0) {
            return 0;
        }

        // 缓存中存在
        if (memo[i][j][moveCount] != -1) {
            return memo[i][j][moveCount];
        }

        // 剪枝：如果小球不管怎么移动都无法越出网格，那就剪掉这个枝
        if (i - moveCount >= 0 && j - moveCount >= 0 && i + moveCount < m && j + moveCount < n) {
            return 0;
        }

        // 从这个点出发的符合条件的路径数量
        int sum = 0;
        for (int[] dir : dirs) {
            // 记得取余
            sum = (sum + dfs(m, n, moveCount - 1, i + dir[0], j + dir[1], memo)) % MOD;
        }

        // 记录缓存
        memo[i][j][moveCount] = sum;

        return sum;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}