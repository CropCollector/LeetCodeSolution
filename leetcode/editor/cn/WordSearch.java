package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：单词搜索
public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        // TO TEST
        System.out.println(solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private char[][] board;

        private int m, n;

        private String word;

        private int[][] direction = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        private Set<List<Integer>> cache = new HashSet<>();

        private boolean[][] flag;

        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.m = board.length;
            this.n = board[0].length;
            this.word = word;
            this.flag = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int index, int i, int j) {
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return false;
            }
            if (flag[i][j]) {
                return false;
            }
            if (word.charAt(index) != board[i][j]) {
                return false;
            }
            if (index == word.length() - 1) {
                return true;
            }

            flag[i][j] = true;
            for (int[] dir : direction) {
                if (dfs(index + 1, i + dir[0], j + dir[1])) {
                    return true;
                }
            }
            flag[i][j] = false;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}