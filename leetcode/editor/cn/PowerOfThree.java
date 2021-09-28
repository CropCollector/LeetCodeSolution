package leetcode.editor.cn;

//Java：3的幂
public class PowerOfThree {
    public static void main(String[] args) {
        Solution solution = new PowerOfThree().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0)
            return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}