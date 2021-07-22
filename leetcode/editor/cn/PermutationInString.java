package leetcode.editor.cn;

import java.util.HashMap;

//Java：字符串的排列
public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        // TO TEST
        solution.checkInclusion(new String("adc"), new String("dcda"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int len = s1.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map1.put(c1, map1.getOrDefault(c1, 0) + 1);
            map2.put(c2, map2.getOrDefault(c2, 0) + 1);
        }

        for (int i = 0; i + len < s2.length(); i++) {
            if (map1.equals(map2)) {
                return true;
            }
            char lc = s2.charAt(i);
            char rc = s2.charAt(i + len);
            int count = map2.get(lc) - 1;
            if (count == 0) {
                map2.remove(lc);
            } else {
                map2.put(lc ,count);
            }
            map2.put(rc, map2.getOrDefault(rc, 0) + 1);
        }
        return map1.equals(map2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}