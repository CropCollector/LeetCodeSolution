package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

//Java：无重复字符的最长子串
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == "") {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int r = 0, l = 0;
        while (l < s.length()) {
            char c = s.charAt(l);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if ((l - r) + 1 != map.keySet().size()) {
                char lc = s.charAt(r);
                int count = map.get(lc) - 1;
                if (count != 0) {
                    map.put(lc, count);
                } else {
                    map.remove(lc);
                }
                r ++;
            }
            l ++;
        }
        return l - r;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}