package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最长回文串
public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int len = s.length();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int ans = 0, single = 0;
            for (Character c : map.keySet()) {
                int count = map.get(c);
                if ((count & 1) == 1) {
                    single = 1;
                    ans += count - 1;
                } else {
                    ans += count;
                }
            }
            return ans + single;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}