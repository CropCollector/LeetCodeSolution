package leetcode.editor.cn;

//Java：数字 1 的个数
public class NumberOfDigitOne {
    public static void main(String[] args) {
        Solution solution = new NumberOfDigitOne().new Solution();
        // TO TEST
        System.out.println(solution.countDigitOne(101));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        //dp[i] - 以i个9拼接起来的数字所包含的1的个数
        int[] dp = new int[11];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (int) (10 * dp[i - 1] + Math.pow(10, i - 1));
        }

        String s = String.valueOf(n);
        int ans = 0, len = s.length();
        for (int i = 0; i < s.length(); i++) {
            int num = Integer.valueOf(String.valueOf(s.charAt(i)));
            if (num == 1) {
                if (i == s.length() - 1) {
                    ans ++;
                } else {
                    ans += Integer.valueOf(s.substring(0, i)) + 1;
                }
            } else if (num >= 2) {
                ans += Math.pow(10, len - 1 - i);
            }
            ans += num * dp[len - 1 - i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}