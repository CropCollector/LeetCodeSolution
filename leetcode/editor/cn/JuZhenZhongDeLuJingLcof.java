package leetcode.editor.cn;

//Java：矩阵中的路径
public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, i, j, word, 0, new boolean[m][n])) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] flag) {
            if (index == word.length()) {
                return true;
            }
            if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
                return false;
            }
            if (board[i][j] != word.charAt(index)) {
                return false;
            }
            if (flag[i][j]) {
                return false;
            }
            flag[i][j] = true;
            index ++;
            boolean result = dfs(board, i + 1, j, word, index, flag)
                    || dfs(board, i - 1, j, word, index, flag)
                    || dfs(board, i, j + 1, word, index, flag)
                    || dfs(board, i, j - 1, word, index, flag);
            if (!result) {
                flag[i][j] = false;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}