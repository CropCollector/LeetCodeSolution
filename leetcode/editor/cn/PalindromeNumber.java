package leetcode.editor.cn;

//Java：回文数
public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        // TO TEST
        System.out.println(solution.isPalindrome(-121));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        String s = ((Integer) x).toString();
        for (int start = 0, end = s.length() - 1; start < end; start ++, end --) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}