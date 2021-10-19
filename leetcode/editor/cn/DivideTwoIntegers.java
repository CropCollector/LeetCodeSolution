package leetcode.editor.cn;

//Java：两数相除
public class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        // TO TEST
        System.out.println(solution.divide(1100540749, -1090366779));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean lt0 = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            lt0 = true;
        }
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        int ans = 0;
        while (dividend <= divisor) {
            int d1 = divisor, res = 1;
            while (d1 >= dividend) {
                dividend -= d1;
                ans += res;

                if (d1 > Integer.MIN_VALUE / 2) {
                    d1 *= 2;
                    res *= 2;
                } else {
                    break;
                }
            }
        }
        return lt0 ? -ans : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}