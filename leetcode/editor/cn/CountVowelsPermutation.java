package leetcode.editor.cn;

import java.util.Arrays;

//Java：统计元音字母序列的数目
public class CountVowelsPermutation {
    public static void main(String[] args) {
        Solution solution = new CountVowelsPermutation().new Solution();
        // TO TEST
        System.out.println(solution.countVowelPermutation(144));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final int MOD = (int) (1e9 + 7);

        public int countVowelPermutation(int n) {
            // dp[i][]分别表示以a,e,i,o,u结尾的字符串数目
            int dpa = 1, dpe = 1, dpi = 1, dpo = 1, dpu = 1;
            for (int i = 2; i <= n; i++) {
                int prev_dpa = dpa, prev_dpe = dpe, prev_dpi = dpi, prev_dpo = dpo, prev_dpu = dpu;
                dpa = sum(prev_dpe, prev_dpi, prev_dpu);
                dpe = sum(prev_dpa, prev_dpi);
                dpi = sum(prev_dpe, prev_dpo);
                dpo = sum(prev_dpi);
                dpu = sum(prev_dpi, prev_dpo);
            }
            return sum(dpa, dpe, dpi, dpo, dpu);
        }

        private int sum(int... nums) {
            int res = 0;
            for (int num : nums) {
                res = (res + num) % MOD;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}