package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

//Java：亲密字符串
public class BuddyStrings {
    public static void main(String[] args) {
        Solution solution = new BuddyStrings().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean buddyStrings(String s, String goal) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int index1 = -1, index2 = -1;
        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(i), c2 = goal.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            if (c1 != c2) {
                if (index1 == -1) {
                    index1 = i;
                } else if (index2 == -1){
                    index2 = i;
                } else {
                    break;
                }
            }
        }
        if (index1 == -1) {
            for (Integer value : map.values()) {
                if (value > 1) {
                    return true;
                }
            }
            return false;
        } else if (index2 == -1) {
            return false;
        } else {
            StringBuffer sb = new StringBuffer(s);
            char c1 = sb.charAt(index1), c2 = sb.charAt(index2);
            sb.replace(index2, index2 + 1, String.valueOf(c1));
            sb.replace(index1, index1 + 1, String.valueOf(c2));
            return sb.toString().equals(goal);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}