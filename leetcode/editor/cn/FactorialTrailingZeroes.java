package leetcode.editor.cn;

//Java：阶乘后的零
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trailingZeroes(int n) {
        int NUM2 = 2, NUM5 = 5;
        int count2 = 0, count5 = 0;
        for (int i = 1; Math.pow(NUM2, i) <= n; i++) {
            count2 += (n / Math.pow(NUM2, i));
        }
        for (int i = 1; Math.pow(NUM5, i) <= n; i++) {
            count5 += (n / Math.pow(NUM5, i));
        }
        return Math.min(count2, count5);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}