//给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。 
//
// 注意：1 ≤ k ≤ n ≤ 10⁹。 
//
// 示例 : 
//
// 
//输入:
//n: 13   k: 2
//
//输出:
//10
//
//解释:
//字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
// Related Topics 字典树 👍 242 👎 0


package leetcode.editor.cn;

public class KThSmallestInLexicographicalOrder {
    public static void main(String[] args) {
        Solution solution = new KThSmallestInLexicographicalOrder().new Solution();
        System.out.println(solution.findKthNumber(681692778, 351251360));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int count = 0;

        private int ans = -1;

        private int k;

        private int n;

        public int findKthNumber(int n, int k) {
            if (k == 1) {
                return 1;
            }
            this.k = k;
            this.n = n;
            for (int i = 1; i <= 9; i++) {
                dfs(i);
            }
            return ans;
        }

        private void dfs(int i) {
            System.out.println(i);
            if (ans != -1) {
                return;
            }
            count ++;
            if (i > n) {
                count --;
                return;
            }
            if (count == k) {
                ans = i;
                return;
            }
            for (int j = 0; j <= 9; j++) {
                dfs(i * 10 + j);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
