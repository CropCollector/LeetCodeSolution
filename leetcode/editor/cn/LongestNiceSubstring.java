package leetcode.editor.cn;

//Java：最长的美好子字符串
public class LongestNiceSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestNiceSubstring().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestNiceSubstring(String s) {
            int len = s.length(), max = 0, l = -1, r = -1;
            for (int i = 0; i < len; i++) {
                int lower = 0, upper = 0;
                for (int j = i; j < len; j++) {
                    char c = s.charAt(j);
                    if (Character.isLowerCase(c)) {
                        lower |= 1 << (c - 'a');
                    } else {
                        upper |= 1 << (c - 'A');
                    }
                    if (lower == upper) {
                       if (j - i + 1 > max) {
                           max = j - i + 1;
                           l = i;
                           r = j;
                       }
                    }
                }
            }
            return max == 0 ? "" : s.substring(l, r + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}