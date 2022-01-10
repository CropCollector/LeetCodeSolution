package leetcode.editor.cn;

import com.sun.tools.javac.comp.Check;

import java.util.HashMap;

//Java：最小覆盖子串
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        // TO TEST
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int sLen = s.length(), tLen = t.length();
            if (sLen < tLen) {
                return "";
            }

            HashMap<Character, Integer> ht = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                ht.put(c, ht.getOrDefault(c, 0) + 1);
            }

            int l = tLen, r = sLen;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (check(mid, s, ht) != "") {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return check(l, s, ht);
        }

        private String check(int size, String s, HashMap<Character, Integer> ht) {
            HashMap<Character, Integer> hs = new HashMap<>();
            for (int i = 0; i < size; i++) {
                char c = s.charAt(i);
                hs.put(c, hs.getOrDefault(c, 0) + 1);
            }
            if (doCheck(hs, ht)) {
                return s.substring(0, size);
            }

            for (int i = size; i < s.length(); i++) {
                char c = s.charAt(i - size), c1 = s.charAt(i);
                hs.put(c, hs.get(c) - 1);
                hs.put(c1, hs.getOrDefault(c1, 0) + 1);
                if (doCheck(hs, ht)) {
                    return s.substring(i - size + 1, i + 1);
                }
            }
            return "";
        }

        private boolean doCheck(HashMap<Character, Integer> hs, HashMap<Character, Integer> ht) {
            for (Character c : ht.keySet()) {
                if (!hs.containsKey(c)) {
                    return false;
                }
                if (hs.get(c) < ht.get(c)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}