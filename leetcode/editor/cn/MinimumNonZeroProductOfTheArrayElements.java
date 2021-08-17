package leetcode.editor.cn;

//Java：数组元素的最小非零乘积
public class MinimumNonZeroProductOfTheArrayElements {
    public static void main(String[] args) {
        Solution solution = new MinimumNonZeroProductOfTheArrayElements().new Solution();
        // TO TEST
        System.out.println(solution.minNonZeroProduct(31));
        //System.out.println(solution.fastPowWithMod(2, 10, 1000000000));
        //System.out.println(Math.pow(2, 10));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minNonZeroProduct(int p) {
        // (int) (Math.pow(Math.pow(2, p) - 2, Math.pow(2, p - 1) - 1) * (Math.pow(2, p) - 1))
        long MOD = (long) (1e9 + 7);
        long tow_p = (1l << p) - 1;
        long tow_p_1 = (1l << (p - 1)) - 1;
        // 138191773
        return (int) ((fastPowWithMod(tow_p - 1, tow_p_1, MOD) % MOD * (tow_p % MOD) % MOD));
    }

    /**
     * @description 快速幂
     * @param base 底数
     * @param exponential 指数
     * @param mod 模数
     */
    private long fastPowWithMod(long base, long exponential, long mod) {
        long result = 1l;
        base = base % mod;
        while (exponential != 0) {
            // exponential % 2 == 1
            if ((exponential & 1) == 1) {
                result = (result * base) % mod;
            }
            // exponential /= 2
            exponential >>= 1;
            base = (base * base) % mod;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}