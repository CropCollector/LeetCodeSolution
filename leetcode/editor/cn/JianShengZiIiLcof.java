package leetcode.editor.cn;

//Java：剪绳子 II
public class JianShengZiIiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiIiLcof().new Solution();
        // TO TEST
        System.out.println(solution.cuttingRope(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope(int n) {
            int MOD = (int) (1e9 + 7);
            if (n <= 3) {
                return n - 1;
            }
            long ans = 1;
            while (n > 4) {
                n -= 3;
                ans = ans * 3 % MOD;
            }
            return (int) (ans * n % MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}