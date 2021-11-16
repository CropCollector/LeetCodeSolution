package leetcode.editor.cn;

//Java：搜索二维矩阵 II
public class SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrixIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int m, n;

        public boolean searchMatrix(int[][] matrix, int target) {
            m = matrix.length;
            n = matrix[0].length;
            return dfs(matrix, target, m - 1, 0);
        }

        private boolean dfs(int[][] matrix, int target, int r, int l) {
            if (r < 0 || r >= m || l < 0 || l >= n) {
                return false;
            }
            int cur = matrix[r][l];
            if (target == cur) {
                return true;
            } else if (target > cur) {
                return dfs(matrix, target, r, l + 1);
            } else {
                return dfs(matrix, target, r - 1, l);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}