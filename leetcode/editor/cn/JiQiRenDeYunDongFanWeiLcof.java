package leetcode.editor.cn;

import java.util.Random;

//Java：机器人的运动范围
public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            boolean[][] flag = new boolean[m][n];
            dfs(0, 0, m, n, flag, k);
            int ans = 0;
            for (boolean[] booleans : flag) {
                for (boolean aBoolean : booleans) {
                    if (aBoolean) {
                        ans ++;
                    }
                }
            }
            return ans;
        }

        private void dfs(int i, int j, int m, int n, boolean[][] flag, int k) {
            if (i < 0 || i == m || j < 0 || j == n) {
                return;
            }
            if (flag[i][j]) {
                return;
            }
            if (i / 10 + i % 10 + j / 10 + j % 10 > k) {
                return;
            }
            flag[i][j] = true;
            dfs(i + 1, j, m, n, flag, k);
            dfs(i - 1, j, m, n, flag, k);
            dfs(i, j + 1, m, n, flag, k);
            dfs(i, j - 1, m, n, flag, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}